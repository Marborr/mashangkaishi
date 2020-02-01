package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.AdministratorDTO;
import life.mashangkaishi.manongcommunity.dto.TeacherClassDTO;
import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.Class;
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

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/administratorRegister")
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
    @PostMapping("/api/user/creatClass")
    public AdministratorDTO creatClass(@RequestBody TeacherClassDTO teacherClassDTO) {
        String result=classService.creatOrUpdateClass(teacherClassDTO);
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.setMsg(result);
        Class aClass = new Class();
        aClass.setClassName(teacherClassDTO.getClassName());
        aClass.setClassNumber(Integer.parseInt(teacherClassDTO.getClassNumber()));
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