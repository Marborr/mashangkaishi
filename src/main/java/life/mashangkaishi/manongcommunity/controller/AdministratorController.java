package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.*;
import life.mashangkaishi.manongcommunity.mapper.ClassMapper;
import life.mashangkaishi.manongcommunity.model.*;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.service.AdministratorService;
import life.mashangkaishi.manongcommunity.service.ClassService;
import life.mashangkaishi.manongcommunity.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;
    @Autowired
    ClassService classService;
    @Autowired
    TaskService taskService;
    @Autowired
    ClassMapper classMapper;

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/teacherRegister")
    public AdministratorDTO regist(@RequestBody Administrator administrator) {
        Administrator administratorSelected = administratorService.selectAdministrator(administrator);
        if (administratorSelected==null){
            administratorService.createOrUpdate(administrator);
            AdministratorDTO administratorDTO = new AdministratorDTO();
            administratorDTO.setMsg("success");
            administratorDTO.setAdministrator(administrator);
            return administratorDTO;
        }else {
            AdministratorDTO administratorDTO = new AdministratorDTO();
            administratorDTO.setMsg("用户已存在");
            return administratorDTO;
        }
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/teacherLogin")
    public AdministratorDTO login(@RequestBody Administrator administrator) {
        Administrator administrator1 = administratorService.selectAdministrator(administrator);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        if (administrator1==null){
            administratorDTO.setMsg("该用户不存在或密码错误 ");
            return administratorDTO;
        }else {
            ClassExample example1 = new ClassExample();
            example1.createCriteria().andMainTeacherEqualTo(administrator.getUsername());
            List<Class> classes = classMapper.selectByExample(example1);
            administratorDTO.setMsg("success");
            administratorDTO.setAdministrator(administrator);
            administratorDTO.setClasses(classes);
            return administratorDTO;
        }
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/creatClass")
    public AdministratorDTO creatClass(@RequestBody TeacherClassDTO2 teacherClassDTO2) {
        int random=(int)((Math.random()*9+1)*100000);
        TeacherClassDTO teacherClassDTO = new TeacherClassDTO();
        teacherClassDTO.setClassName(teacherClassDTO2.getClassName());
        teacherClassDTO.setClassNumber(String.valueOf(random));
        teacherClassDTO.setTeacherName(teacherClassDTO2.getTeacherName());
        String result=classService.creatOrUpdateClass(teacherClassDTO);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setMsg(result);
        Class aClass = new Class();
        aClass.setClassName(teacherClassDTO.getClassName());
        aClass.setClassNumber(random);
        aClass.setMainTeacher(teacherClassDTO.getTeacherName());
        administratorDTO.setClassMessege(aClass);
        return administratorDTO;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/creatTask")
    public AdministratorDTO creatTask(@RequestBody Task task) {
        String result=taskService.creatOrUpdateTask(task);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setMsg(result);
        administratorDTO.setTask(task);
        return administratorDTO;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/selectClassTask")//查任务
    public List<Task> selectClassTask(@RequestBody Task task) {
        List<Task> tasks=taskService.selectClassTask(task);
        return tasks;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/selectClasses")//查班级
    public List<Class> selectClasses(@RequestBody Administrator administrator) {
        List<Class> classes=classService.selectClasses(administrator);
        return classes;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/selectClassStudentTask")//查学生任务
    public List<StudentTaskStateDTO> selectClassStudentTask(@RequestBody Task task) {
        List<StudentTaskStateDTO> selectStudentClassTask=taskService.selectStudentClassTask(task);
        return selectStudentClassTask;
    }

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/selectClassStudent")//查学生
    public StudentNameDTO selectClassStudent(@RequestBody Class aclass) {

        Class StudentClass=taskService.selectStudentClass(aclass);
        StudentNameDTO studentNameDTO = new StudentNameDTO();
        studentNameDTO.setStudentName(StudentClass.getStudents());
        return studentNameDTO;
    }


}
