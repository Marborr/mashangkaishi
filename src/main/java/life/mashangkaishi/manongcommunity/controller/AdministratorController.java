package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.AdministratorDTO;
import life.mashangkaishi.manongcommunity.dto.TeacherClassDTO;
import life.mashangkaishi.manongcommunity.dto.TeacherClassDTO2;
import life.mashangkaishi.manongcommunity.mapper.ClassMapper;
import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.ClassExample;
import life.mashangkaishi.manongcommunity.model.Task;
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
    public AdministratorDTO creatClass(@RequestBody TeacherClassDTO2 teacherClassDTO) {
        String result=classService.creatOrUpdateClass(teacherClassDTO);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setMsg(result);
        Class aClass = new Class();
        aClass.setClassName(teacherClassDTO.getClassName());
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
    @PostMapping("/api/user/selectClassStudentTask")//查作业
    public List<Task> selectClassStudentTask(@RequestBody Task task) {
        List<Task> tasks=taskService.selectClassStudentTask(task);
        return tasks;
    }
}
