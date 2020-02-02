package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.TeacherClassDTO;
import life.mashangkaishi.manongcommunity.mapper.AdministratorMapper;
import life.mashangkaishi.manongcommunity.mapper.ClassExtMapper;
import life.mashangkaishi.manongcommunity.mapper.ClassMapper;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.model.*;
import life.mashangkaishi.manongcommunity.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassExtMapper classExtMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdministratorMapper administratorMapper;
    public String creatOrUpdateClass(TeacherClassDTO teacherClass) {
        Class classMassege = new Class();
        classMassege.setClassNumber(Integer.parseInt(teacherClass.getClassNumber()));
        classMassege.setClassName(teacherClass.getClassName());
        AdministratorExample administratorExample = new AdministratorExample();
        administratorExample.createCriteria().andUsernameEqualTo(teacherClass.getTeacherName());
        List<Administrator> administrators = administratorMapper.selectByExample(administratorExample);
        ClassExample example = new ClassExample();
        example.createCriteria().andClassNameEqualTo(classMassege.getClassName())
                .andClassNumberEqualTo(classMassege.getClassNumber());
        List<Class> classes = classMapper.selectByExample(example);
        if (administrators.size() != 0) {
            if (classes.size() == 0) {
                if (administrators.get(0).getClassName() == null) {
                    administrators.get(0).setClassName(teacherClass.getClassName());
                    administrators.get(0).setClassNumber(teacherClass.getClassNumber());
                } else {
                    administrators.get(0).setClassNumber(administrators.get(0).getClassNumber()
                            + "," + teacherClass.getClassNumber());
                    administrators.get(0).setClassName(administrators.get(0).getClassName()
                            + "," + teacherClass.getClassName());
                }
                int random=(int)((Math.random()*9+1)*100000);
                classMassege.setId(classExtMapper.selectClassNumber(classMassege) + 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                classMassege.setGmtCreat(df.format(new Date()));
                classMassege.setMainTeacher(teacherClass.getTeacherName());
                classMassege.setClassNumber(random);
                classMapper.insert(classMassege);
                administratorMapper.updateByPrimaryKey(administrators.get(0));
                return "班级创建成功";
            } else {
                return "已创建此班级";
            }
        }else {
            return "教师信息有误，请确认后再次创建";
        }
    }

    public String joinClass(Class classMassege, Student student) {
        ClassExample example = new ClassExample();
        example.createCriteria().andClassNameEqualTo(classMassege.getClassName())
                .andClassNumberEqualTo(classMassege.getClassNumber());
        List<Class> classes = classMapper.selectByExample(example);
        if (classes.size() != 0) {
            StudentExample example1 = new StudentExample();
            example1.createCriteria().andUsernameEqualTo(student.getUsername());
            List<Student> students = studentMapper.selectByExample(example1);
            if (students.size() != 0) {
                if (classes.get(0).getStudents() == null) {
                    classes.get(0).setStudents(student.getUsername());
                } else {
                    classes.get(0).setStudents(classes.get(0).getStudents() + "," + student.getUsername());
                }
                classMapper.updateByPrimaryKey(classes.get(0));
                if (students.get(0).getClassNumber() == null && students.get(0).getClassName() == null) {
                    students.get(0).setClassName(student.getClassName());
                    students.get(0).setClassNumber(student.getClassNumber());
                    studentMapper.updateByPrimaryKey(students.get(0));
                    return "班级加入成功";
                } else if (students.get(0).getClassNumber().contains(student.getClassNumber()) && students.get(0).getClassName().contains(student.getClassName())) {
                    return "已加入该班级";
                } else {
                    students.get(0).setClassName(students.get(0).getClassName() + "," + student.getClassName());
                    students.get(0).setClassNumber(students.get(0).getClassNumber() + "," + student.getClassNumber());
                    studentMapper.updateByPrimaryKey(students.get(0));
                    return "班级加入成功";
                }
            } else {
                return "学生信息有误";
            }
        } else {
            return "无此班级";
        }
    }


}
