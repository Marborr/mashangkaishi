package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.StudentTaskDAO;
import life.mashangkaishi.manongcommunity.dto.StudentTaskStateDTO;
import life.mashangkaishi.manongcommunity.mapper.ClassMapper;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.mapper.TaskExtMapper;
import life.mashangkaishi.manongcommunity.mapper.TaskMapper;
import life.mashangkaishi.manongcommunity.model.*;
import life.mashangkaishi.manongcommunity.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskExtMapper taskExtMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassMapper classMapper;

    public String creatOrUpdateTask(Task task) {
        task.setId(taskExtMapper.selectTaskNumber(task) + 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        task.setGmtCreat(df.format(new Date()));
        taskMapper.insert(task);
        return "任务创建成功";
    }

    public List<Task> selectTask(Task task) {
        TaskExample example = new TaskExample();
        example.createCriteria().andClassMessageEqualTo(task.getClassMessage())
                .andTeacherEqualTo(task.getTeacher());
        List<Task> tasks = taskMapper.selectByExample(example);
        return tasks;
    }

    public String studentCreatOrUpdateTask(Task task) {
        TaskExample example = new TaskExample();
        example.createCriteria()
                .andClassMessageEqualTo(task.getClassMessage())
                .andTeacherEqualTo(task.getTeacher())
                .andStudentNumberEqualTo(task.getStudentNumber())
                .andTaskNameEqualTo(task.getTaskName());
        List<Task> tasks = taskMapper.selectByExample(example);
        StudentExample example1 = new StudentExample();
        example1.createCriteria().andStuIdEqualTo(task.getStudentNumber());
        List<Student> students = studentMapper.selectByExample(example1);
        if (students.size() != 0) {
            if (tasks.size() != 0) {
                tasks.get(0).setDescription(task.getDescription());
                TaskExample taskExample = new TaskExample();
                taskExample.createCriteria().andIdEqualTo(tasks.get(0).getId());
                taskMapper.updateByExampleWithBLOBs(tasks.get(0), taskExample);
                return "提交成功";
            } else {
                task.setId(taskExtMapper.selectTaskNumber(task) + 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                task.setGmtCreat(df.format(new Date()));
                students.get(0).setTaskDone(students.get(0).getTaskDone() + 1);
                studentMapper.updateByPrimaryKey(students.get(0));
                taskMapper.insert(task);
                return "任务创建成功";
            }
        } else {
            return "学生信息有误，请重输";
        }
    }


    public List<Task> selectClassTask(Task task) {
        TaskExample example = new TaskExample();
        example.createCriteria()
                .andClassMessageEqualTo(task.getClassMessage())
                .andTeacherEqualTo(task.getTeacher())
                .andStudentNumberIsNull();
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);
        return tasks;
    }

    public List<StudentTaskStateDTO> selectStudentClassTask(Task task) {
        List<StudentTaskStateDTO> studentTaskStateDTOS = new ArrayList<>();
        TaskExample example = new TaskExample();
        example.createCriteria().andClassMessageEqualTo(task.getClassMessage())
                .andTeacherEqualTo(task.getTeacher())
                .andTaskNameEqualTo(task.getTaskName());
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);

        StudentExample example1 = new StudentExample();
        example1.createCriteria().andClassNumberLike(task.getClassMessage());
        List<Student> students = studentMapper.selectByExample(example1);
        for (Student s :
                students) {
            StudentTaskStateDTO studentTaskStateDTO = new StudentTaskStateDTO();
            studentTaskStateDTO.setUsername(s.getStuId());
            studentTaskStateDTO.setSate("未完成");
            for (Task t :
                    tasks) {
                if (s.getStuId().equals(t.getStudentNumber())) {
                    studentTaskStateDTO.setSate("完成");
                }
            }
            studentTaskStateDTOS.add(studentTaskStateDTO);
        }
        return studentTaskStateDTOS;
    }


    public StudentTaskDAO selectStudentTask(Student student) {
        StudentExample Studentexample = new StudentExample();
        Studentexample.createCriteria().andStuIdEqualTo(student.getStuId());
        List<Student> students = studentMapper.selectByExample(Studentexample);
        if (students.size()==0){
            return null;
        }else {
            StudentTaskDAO studentTaskDAO = new StudentTaskDAO();
            ArrayList<Class> listclass = new ArrayList<>();
            String[] classesNumber = students.get(0).getClassNumber().split(",");

            System.out.println(Arrays.toString(classesNumber));

            if (classesNumber.length!=0){
                ClassExample classexample = new ClassExample();
                for (String classes :
                        classesNumber) {
                    classexample.createCriteria()
                            .andClassNumberEqualTo(Integer.parseInt(classes));
                    List<Class> classes1 = classMapper.selectByExample(classexample);
                    listclass.add(classes1.get(0));
                }
            }
            studentTaskDAO.setClasses(listclass);

            TaskExample example = new TaskExample();
            example.createCriteria()
                    .andStudentNumberEqualTo(students.get(0).getStuId());
            List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);
            studentTaskDAO.setTasks(tasks);
            return studentTaskDAO;
        }
    }

    public Class selectStudentClass(Class aclass) {
        ClassExample example = new ClassExample();
        example.createCriteria().andClassNumberEqualTo(aclass.getClassNumber());
        List<Class> classes = classMapper.selectByExample(example);
        return classes.get(0);
    }
}
