package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.StudentDTO;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CardController {
    @Autowired
    StudentService studentService;

    @Transactional
    @ResponseBody
    @GetMapping("/api/user/cardpage") //排名
    public List<Student> CardPage(){
        List<Student> students = studentService.selectRankStudents();
        for (int i = 0; i <students.size(); i++) {
            students.get(i).setRankNumber(i+1);
        }
        return students;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/cardclockin") //打卡(传入用户名）
    public StudentDTO Clockin(@RequestBody Student student){
        StudentDTO students=new StudentDTO();
        students.setMsg("打卡成功");
        Student studentclockin = studentService.selectStudent(student);
        if (studentclockin.getCardNumber()!=null){
            studentclockin.setCardNumber(studentclockin.getCardNumber()+1);
        }else {
            studentclockin.setCardNumber((long)1);
        }
        studentService.createOrUpdate(studentclockin);
        students.setStudent(studentclockin);
        return students;
    }

}
