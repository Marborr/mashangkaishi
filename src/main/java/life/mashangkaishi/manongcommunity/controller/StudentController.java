package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.*;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.Task;
import life.mashangkaishi.manongcommunity.service.*;
import life.mashangkaishi.manongcommunity.util.CustomStringJavaCompiler;
import life.mashangkaishi.manongcommunity.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    SendMail sendMail;
    @Autowired
    StudentService studentService;

    @Autowired
    ClassService classService;
    @Autowired
    TaskService taskService;
    @Autowired
    MailService mailService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;



    @ResponseBody
    @PostMapping("/api/user/register")
    public StudentDTO regist(@RequestBody Student student) {
        Student selectStudent = studentService.selectStudent(student);
        Mes mes=new Mes();
        if (selectStudent==null){
            Student student1 = studentService.create(student);
            StudentDTO studentDTO = new StudentDTO();

            if (student1!=null)
            {
                mes.setErr(0);
                mes.setMsg("注册成功");
                studentDTO.setMes(mes);
            }
            else {
                mes.setErr(1);
                mes.setMsg("验证码有误或失效");
                studentDTO.setMes(mes);
            }
            return studentDTO;
        }else {
            StudentDTO studentDTO = new StudentDTO();
            mes.setErr(1);
            mes.setMsg("用户已存在");
            studentDTO.setMes(mes);
            return studentDTO;
        }
    }


    @ResponseBody
    @PostMapping("/api/user/login")
    public StudentDTO login(@RequestBody Student student) {
        Student selectStudent = studentService.selectStudentByPassword(student);
        StudentDTO studentDTO = new StudentDTO();
        Mes mes=new Mes();
        if (selectStudent==null){
            mes.setErr(1);
            mes.setMsg("用户不存在或密码错误");
            studentDTO.setMes(mes);
            return studentDTO;
        }else {
            mes.setErr(0);
            mes.setMsg("登录成功");
            studentDTO.setMes(mes);
            return studentDTO;
        }
    }


    @ResponseBody
    @PostMapping("/api/user/findpassword")  //(需要传入用户名）
    public StudentDTO findPassword(@RequestBody Student student){
        Student updateStudent = studentService.updatepassword(student);
        StudentDTO studentDTO = new StudentDTO();
        Mes mes=new Mes();
        if (updateStudent!=null){
            mes.setErr(0);
            mes.setMsg("密码更新成功");
            studentDTO.setMes(mes);
            return studentDTO;
        }else {
            mes.setErr(1);
            mes.setMsg("用户不存在或验证码错误");
            studentDTO.setMes(mes);
            return studentDTO;
        }
    }


    @ResponseBody
    @PostMapping("/api/user/validationemail")  //(邮箱验证）
    public StudentDTO ValidationEmail(@RequestBody Student student){
        int random=(int)((Math.random()*9+1)*100000);
        student.setVerificationCode(random);
        StudentDTO studentDTO = new StudentDTO();
        int tag=sendMail.send(student.getEmail(),student.getVerificationCode());
        Mes mes=new Mes();
        if (tag==1){
            mailService.InsertData(student.getEmail(),String.valueOf(random));
            mes.setErr(0);
            mes.setMsg("邮件已发送");
            studentDTO.setMes(mes);
            return studentDTO;
        }else {
            mes.setErr(1);
            mes.setMsg("邮件发送失败");
            studentDTO.setMes(mes);
            return studentDTO;
        }
    }

//    @PostConstruct
//    public void init(){
//        TaskAndPageDTO task = new TaskAndPageDTO();
//
//        List<Task> tasks=taskService.selectAllTask(task,"SelectTask");
//        for (Task t:
//             tasks) {
//            stringRedisTemplate.opsForValue().set("task"+t.getId(),t+"");
//        }
//    }


    @ResponseBody
    @PostMapping("/api/user/studentSelectTask")
    public PageTask studentSelectTask(@RequestBody TaskAndPageDTO task) {
        PageTask tasks=taskService.selectTask(task,"SelectTask");
        return tasks;
    }




    @ResponseBody
    @PostMapping("/api/user/AllTaskNameStudentSelectTask")
    public PageTask studentAllSelectTask(@RequestBody TaskAndPageDTO task) {
        PageTask tasks=taskService.selectTask(task,"AllNameSelectTask");
        return tasks;
    }



    @ResponseBody
    @PostMapping("/api/user/studentCreatOrUpdateTask")
    public Mes studentCreatOrUpdateTask(@RequestBody Task task) {
        Mes mes = taskService.studentCreatOrUpdateTask(task);
        return mes;
    }

    //@Async("asyncExecutor")

    @ResponseBody
    @PostMapping("/api/user/studentMessage")
    public PageTask studentMessage(@RequestBody TaskAndPageDTO student) {
        PageTask pageTask = taskService.selectStudentTask(student);
        return pageTask;
    }


    @ResponseBody
    @PostMapping("/api/user/ExecuteJavaCode")
    public CodeCompiler ExecuteJavaCode(@RequestBody Task task) {
        String code=task.getDescription();
        CustomStringJavaCompiler compiler = new CustomStringJavaCompiler(code);

        boolean res = compiler.compiler();
        CodeCompiler codeCompiler = new CodeCompiler();
        if (res) {
            codeCompiler.setCompilerMessage("编译成功");
            codeCompiler.setCompilerTakeTime("编译时长：" + compiler.getCompilerTakeTime());
            try {
                compiler.runMainMethod();
                codeCompiler.setRunTakeTime("运行时长：" + compiler.getRunTakeTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            codeCompiler.setResult(compiler.getRunResult());
            //codeCompiler.setDetail("诊断信息：" + compiler.getCompilerMessage());
        } else {
            codeCompiler.setCompilerMessage("编译失败");
            codeCompiler.setDetail(compiler.getCompilerMessage());
        }
        return codeCompiler;
    }



}
