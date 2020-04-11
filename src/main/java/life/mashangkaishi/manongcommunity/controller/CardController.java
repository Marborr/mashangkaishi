package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.Mes;
import life.mashangkaishi.manongcommunity.dto.StudentDTO;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.StudentExample;
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
    @Autowired
    StudentMapper studentMapper;


    @ResponseBody
    @PostMapping("/api/user/cardpage") //排名
    public List<Student> CardPage(@RequestBody Student student){
        List<Student> students = studentService.selectRankStudents(student);
        for (int i = 0; i <students.size()-1; i++) {
            students.get(i).setRankNumber(i+1);
        }
        return students;
    }



    @ResponseBody
    @PostMapping("/api/user/cardclockin") //打卡(传入用户名）
    public StudentDTO Clockin(@RequestBody Student student){
        StudentDTO studentDTO=new StudentDTO();
        Mes mes=new Mes();
        mes.setErr(1);
        mes.setMsg("打卡成功");
        studentDTO.setMes(mes);
        Student studentclockin = studentService.selectStudent(student);
        if (studentclockin.getCardNumber()!=null){
            studentclockin.setCardNumber(studentclockin.getCardNumber()+1);
        }else {
            studentclockin.setCardNumber(1);
        }
        studentMapper.updateByPrimaryKey(studentclockin);
        return studentDTO;
    }

}
