package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.AdministratorDTO;
import life.mashangkaishi.manongcommunity.dto.DataDTO;
import life.mashangkaishi.manongcommunity.dto.JoinClassDTO;
import life.mashangkaishi.manongcommunity.dto.StudentDTO;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Data;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.Task;
import life.mashangkaishi.manongcommunity.service.ClassService;
import life.mashangkaishi.manongcommunity.service.DataService;
import life.mashangkaishi.manongcommunity.service.StudentService;
import life.mashangkaishi.manongcommunity.service.TaskService;
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
    DataService dataService;
    @Autowired
    ClassService classService;
    @Autowired
    TaskService taskService;

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/registerOrUpdate")
    public StudentDTO regist(@RequestBody Student student) {
        Student selectStudent = studentService.selectStudent(student);
        if (selectStudent==null){
            studentService.createOrUpdate(student);
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setMsg("success");
            return studentDTO;
        }else {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setMsg("用户已存在");
            return studentDTO;
        }
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/login")
    public StudentDTO login(@RequestBody Student student) {
        Student selectStudent = studentService.selectStudentByPassword(student);
        StudentDTO studentDTO = new StudentDTO();
        if (selectStudent==null){
            studentDTO.setMsg("该用户不存在或密码错误");
            return studentDTO;
        }else {
            studentDTO.setMsg("success");
            studentDTO.setStudent(selectStudent);
            return studentDTO;
        }
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/findpassword")  //(需要传入用户名）
    public StudentDTO findPassword(@RequestBody Student student){
        int random=(int)((Math.random()*9+1)*100000);
        student.setVerificationCode(random);
        Student updateStudent = studentService.createOrUpdate(student);
        StudentDTO studentDTO = new StudentDTO();
        int tag=sendMail.send(updateStudent.getEmail(),updateStudent.getVerificationCode());
        if (tag==1){
            studentDTO.setMsg("邮件已发送");
            studentDTO.setStudent(updateStudent);
            return studentDTO;
        }else {
            studentDTO.setMsg("邮件发送失败");
            studentDTO.setStudent(updateStudent);
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
        if (tag==1){
            studentDTO.setMsg("邮件已发送");
            studentDTO.setStudent(student);
            return studentDTO;
        }else {
            studentDTO.setMsg("邮件发送失败");
            studentDTO.setStudent(student);
            return studentDTO;
        }
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/dataChange")  //(数据变更）
    public DataDTO DataChange(@RequestBody DataDTO dataDTO){
        Data data = new Data();
        data.setTitle(dataDTO.getTitle());
        data.setTag(dataDTO.getTag());
        data.setDescription(dataDTO.getDescription());
        data.setCreator(dataDTO.getUsername());
        dataDTO.setMsg( dataService.creatOrUpdateData(data));
        return dataDTO;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/joinClass")
    public AdministratorDTO creatClass(@RequestBody JoinClassDTO joinClassDTO) {
        Class joinclass = new Class();
        Student student = new Student();
        joinclass.setClassName(joinClassDTO.getClassName());
        joinclass.setClassNumber(joinClassDTO.getClassNumber());
        student.setUsername(joinClassDTO.getStudentUsername());
        student.setClassNumber(String.valueOf(joinClassDTO.getClassNumber()));
        student.setClassName(joinClassDTO.getClassName());
        String result=classService.joinClass(joinclass,student);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setMsg(result);
        administratorDTO.setClassName(joinClassDTO.getClassName());
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
        administratorDTO.setMsg(result);
        administratorDTO.setTask(task);
        return administratorDTO;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/studentMessage")
    public Task studentMessage(@RequestBody Task task) {
        Task task1 = taskService.selectStudentTask(task);
        return task1;
    }

}
