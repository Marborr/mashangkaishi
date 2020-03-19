package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.*;
import life.mashangkaishi.manongcommunity.mapper.ClassMapper;
import life.mashangkaishi.manongcommunity.mapper.StudentMapper;
import life.mashangkaishi.manongcommunity.mapper.TaskExtMapper;
import life.mashangkaishi.manongcommunity.mapper.TaskMapper;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.*;
import life.mashangkaishi.manongcommunity.util.TimeFlush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    TimeFlush timeFlush;

    public String creatOrUpdateTask(Task task) {
        try {
            boolean timeout = timeFlush.timeout(task.getDeadline());
            if (!timeout) {
                task.setState("进行中");
            } else {
                task.setState("已过期");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        task.setGmtCreat(df.format(new Date()));
        taskMapper.insert(task);
        return "任务创建成功";
    }


    public PageTask selectTask(TaskAndPageDTO task, String type) {

        Integer offset = task.getLimit() * (task.getPage() - 1);//页面偏移量

        TaskExample example = new TaskExample();
        example.setOffset(offset);
        example.setLimit(task.getLimit());

        switch (type) {
            case "SelectTask": {
                example.createCriteria()
                        .andTaskNameLike("%" + task.getTaskName() + "%")
                        .andStudentNumberIsNotNull();

                break;
            }
            case "AllNameSelectTask": {
                example.createCriteria()
                        .andTaskNameEqualTo(task.getTaskName())
                        .andStudentNumberIsNotNull();
                break;
            }
            case "SelectTeacherTask": {

                example.createCriteria()
                        .andTeacherEqualTo(task.getTeacher())
                        .andStudentNumberIsNull();
                break;
            }
        }
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);

        if (tasks.size() == 0) {
            return null;
        } else {
            try {
                for (int i = 0; i < tasks.size(); i++) {
                    Task t = tasks.get(i);
                    boolean timeout = timeFlush.timeout(t.getDeadline());
                    if (!timeout) {
                        t.setState("进行中");
                        tasks.get(i).setState("进行中");
                    } else {
                        t.setState("已过期");
                        tasks.get(i).setState("已过期");
                    }
                    System.out.println(tasks.get(i));
                    taskMapper.updateByPrimaryKeyWithBLOBs(t);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Integer integer = taskExtMapper.selectTaskNumber();
            PageTask pageTask = new PageTask();
            if (integer % task.getLimit() != 0)
                integer = integer / task.getLimit() + 1;
            else
                integer = integer / task.getLimit();
            pageTask.setAllTasks(integer);
            pageTask.setTasks(tasks);
            return pageTask;
        }
    }

    public Mes studentCreatOrUpdateTask(Task task) {
        TaskExample example = new TaskExample();
        example.createCriteria()
                .andStudentNumberEqualTo(task.getStudentNumber())
                .andTaskNameEqualTo(task.getTaskName());
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);

        StudentExample example1 = new StudentExample();
        example1.createCriteria().andStuIdEqualTo(task.getStudentNumber());
        List<Student> students = studentMapper.selectByExample(example1);

        Mes mes = new Mes();
        if (students.size() != 0) {
            if (tasks.size() != 0) {
                tasks.get(0).setDescription(task.getDescription());
                TaskExample taskExample = new TaskExample();
                taskExample.createCriteria().andIdEqualTo(tasks.get(0).getId());
                taskMapper.updateByExampleWithBLOBs(tasks.get(0), taskExample);
                mes.setErr(0);
                mes.setMsg("提交成功");
                return mes;
            } else {
                //task.setId(taskExtMapper.selectTaskNumber(task) + 1);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                task.setGmtCreat(df.format(new Date()));
                students.get(0).setTaskDone(students.get(0).getTaskDone() + 1);
                studentMapper.updateByPrimaryKey(students.get(0));
                taskMapper.insert(task);
                mes.setErr(0);
                mes.setMsg("任务创建成功");
                return mes;
            }
        } else {
            mes.setErr(1);
            mes.setMsg("学生信息有误请重新输入");
            return mes;
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


    public PageTask selectStudentTask(TaskAndPageDTO task) {
        TaskExample example = new TaskExample();
        Integer offset = task.getLimit() * (task.getPage() - 1);//页面偏移量

        example.setOffset(offset);
        example.setLimit(task.getLimit());
        example.createCriteria().andStudentNumberEqualTo(task.getStuId());
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);
        Integer integer = taskExtMapper.selectTaskNumber();
        if (integer % task.getLimit() != 0)
            integer = integer / task.getLimit() + 1;
        else
            integer = integer / task.getLimit();
        PageTask pageTask = new PageTask();
        pageTask.setAllTasks(integer);
        pageTask.setTasks(tasks);

        return pageTask;
    }


    public Class selectStudentClass(Class aclass) {
        ClassExample example = new ClassExample();
        example.createCriteria().andClassNumberEqualTo(aclass.getClassNumber());
        List<Class> classes = classMapper.selectByExample(example);
        return classes.get(0);
    }

    public Mes creatTask(Task task) {
        TaskExample example = new TaskExample();
        example.createCriteria()
                .andTaskNameEqualTo(task.getTaskName())
                .andTeacherEqualTo(task.getTeacher())
                .andStudentNumberIsNull();
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);
        Mes mes = new Mes();
        if (tasks.size() == 0) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            task.setGmtCreat(df.format(new Date()));
            taskMapper.insert(task);
        } else {
            mes.setErr(1);
            mes.setMsg("任务已存在");
            return mes;
        }
        mes.setErr(0);
        mes.setMsg("创建成功");
        return mes;
    }


    public List<TeacherTask> selectTeacherTask() {
        List<TeacherTask> teacherTasks = new ArrayList<>();
        Set<String> teacherTaskSet = new HashSet<>();

        TaskExample example = new TaskExample();
        example.createCriteria()
                .andStudentNumberIsNull();
        List<Task> tasks = taskMapper.selectByExampleWithBLOBs(example);
        System.out.println(tasks.size());

        for (Task t :
                tasks) {
            teacherTaskSet.add(t.getTeacher());
        }

        for (String teacherName : teacherTaskSet) {
            ArrayList<Task> arrayTask = new ArrayList<>();
            TeacherTask teacherTask = new TeacherTask();
            for (Task t :
                    tasks) {
                if (teacherName.equals(t.getTeacher())) {
                    arrayTask.add(t);
                }
            }
            teacherTask.setTeacherId(teacherName);
            teacherTask.setTasks(arrayTask);
            teacherTasks.add(teacherTask);
        }
        return teacherTasks;
    }
}
