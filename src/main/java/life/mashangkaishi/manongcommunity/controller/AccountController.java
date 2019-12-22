package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.StudentDTO;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.service.StudentService;
import life.mashangkaishi.manongcommunity.util.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {
    @Autowired
    SendMail sendMail;
    @Autowired
    StudentService studentService;

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

}
