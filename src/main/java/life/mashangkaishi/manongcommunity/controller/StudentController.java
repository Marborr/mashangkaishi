package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.*;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.Task;
import life.mashangkaishi.manongcommunity.service.*;
import life.mashangkaishi.manongcommunity.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Transactional
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

    @Transactional
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

    @Transactional
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
            mes.setMsg("密码更新失败");
            studentDTO.setMes(mes);
            return studentDTO;
        }
    }

    @Transactional
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


    @Transactional
    @ResponseBody
    @PostMapping("/api/user/joinClass")
    public AdministratorDTO creatClass(@RequestBody JoinClassDTO joinClassDTO) {
        Class joinclass = new Class();
        Student student = new Student();
        joinclass.setClassName(joinClassDTO.getClassName());
        joinclass.setClassNumber(joinClassDTO.getClassNumber());
        student.setStuId(joinClassDTO.getStudentUsername());
        student.setClassNumber(String.valueOf(joinClassDTO.getClassNumber()));
        student.setClassName(joinClassDTO.getClassName());
        String result=classService.joinClass(joinclass,student);
        AdministratorDTO administratorDTO = new AdministratorDTO();
//        administratorDTO.setMsg(result);
//        administratorDTO.setClassName(joinClassDTO.getClassName());
        return administratorDTO;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/studentSelectTask")
    public List<Task> studentSelectTask(@RequestBody Task task) {
        List<Task> tasks=taskService.selectTask(task);
        return tasks;
    }


    @Transactional
    @ResponseBody
    @PostMapping("/api/user/studentCreatOrUpdateTask")
    public AdministratorDTO studentCreatOrUpdateTask(@RequestBody Task task) {
        String result=taskService.studentCreatOrUpdateTask(task);
        AdministratorDTO administratorDTO = new AdministratorDTO();
//        administratorDTO.setMsg(result);
//        administratorDTO.setTask(task);
        return administratorDTO;
    }

    //@Async("asyncExecutor")
    @Transactional
    @ResponseBody
    @PostMapping("/api/user/studentMessage")
    public List<Task> studentMessage(@RequestBody Student student) {
        List<Task> tasks = taskService.selectStudentTask(student);
        return tasks;
    }



}
