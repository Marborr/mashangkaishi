package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.StudentExtMapper;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.model.Student;
import life.mashangkaishi.manongcommunity.model.StudentExample;
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
    public Student createOrUpdate(Student student){
//        if (student.getId()==null){
//            student.setId(studentExtMapper.selectStudentNumber(student)+1);//查询所有学生的总数
//        }
        StudentExample example=new StudentExample();
        example.createCriteria().andStuIdEqualTo(student.getStuId());
        List<Student> students = studentMapper.selectByExample(example);
        if(students.size() ==0){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            //插入
            student.setGmtCreate(df.format(new Date()));
            student.setTaskDone(0);
            student.setTaskNotDone(0);
            student.setIdentify("student");
            studentMapper.insert(student);
            return student;

        }else {
            //更新
            Student dbStudent = students.get(0);
            if (dbStudent.getVerificationCode()!=null ||dbStudent.getVerificationCode()==student.getVerificationCode())
            {
                dbStudent.setPassword(student.getPassword());
            }
            dbStudent.setVerificationCode(student.getVerificationCode());
            StudentExample example1 = new StudentExample();
            example1.createCriteria().andIdEqualTo(dbStudent.getId());
            studentMapper.updateByExampleSelective(dbStudent, example1);
            return dbStudent;
        }
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
