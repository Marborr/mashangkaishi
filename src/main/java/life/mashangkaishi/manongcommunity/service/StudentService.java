package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.StudentExtMapper;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.mapper.mailIdentifyMapper;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.StudentExample;
import life.mashangkaishi.manongcommunity.model.mailIdentify;
import life.mashangkaishi.manongcommunity.model.mailIdentifyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentExtMapper studentExtMapper;
    @Autowired
    mailIdentifyMapper mailIdentifyMapper;

    public Student create(Student student){
        mailIdentifyExample mailexample = new mailIdentifyExample();
        mailexample.createCriteria().andEmailEqualTo(student.getEmail());
        List<mailIdentify> mailIdentifies
                = mailIdentifyMapper.selectByExample(mailexample);
        if (mailIdentifies.size()==0){
            return null;
        }
        if (String.valueOf(student.getVerificationCode()).equals(mailIdentifies.get(mailIdentifies.size()-1).getIdentifyNumber())){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            student.setGmtCreate(df.format(new Date()));
            student.setTaskDone(0);
            student.setTaskNotDone(0);
            student.setIdentify("student");
            studentMapper.insert(student);
            return student;
        }else {
            return null;
        }
    }

    public Student updatepassword(Student student){
        Student student1 = selectStudent(student);
        mailIdentifyExample mailexample = new mailIdentifyExample();
        mailexample.createCriteria().andEmailEqualTo(student.getEmail());
        List<mailIdentify> mailIdentifies
                = mailIdentifyMapper.selectByExample(mailexample);
        if (mailIdentifies.size()==0 ||student1==null){
            return null;
        }
        System.out.println(mailIdentifies.get(mailIdentifies.size()-1).getIdentifyNumber());
        if (String.valueOf(student.getVerificationCode()).equals(mailIdentifies.get(mailIdentifies.size()-1).getIdentifyNumber())){
            student1.setPassword(student.getPassword());
            studentMapper.updateByPrimaryKey(student1);
            return student;
        }else
            return null;
    }


    public Student selectStudent(Student student){
        StudentExample example=new StudentExample();
        example.createCriteria().andStuIdEqualTo(student.getStuId());
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size()==0){
            return null;
        }
        return students.get(0);
    }

    public List<Student> selectRankStudents(){
        StudentExample example=new StudentExample();
        example.setOrderByClause("card_number desc");
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size()==0){
            return null;
        }
        if (students.size()<10){
            return students.subList(0,students.size());
        }else {
            return students.subList(0,10);
        }
    }

    public Student selectStudentByPassword(Student student) {
        StudentExample example=new StudentExample();
        example.createCriteria().andPasswordEqualTo(student.getPassword())
                .andStuIdEqualTo(student.getStuId());
        List<Student> students = studentMapper.selectByExample(example);
        if (students.size()==0){
            return null;
        }
        return students.get(0);
    }
}
