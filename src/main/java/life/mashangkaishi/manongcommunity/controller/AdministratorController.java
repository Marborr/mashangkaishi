package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.AdministratorDTO;
import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.service.AdministratorService;
import life.mashangkaishi.manongcommunity.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;
    @Autowired
    ClassService classService;

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/administratorRegister")
    public AdministratorDTO regist(@RequestBody Administrator administrator) {
        Administrator administratorSelected = administratorService.selectAdministrator(administrator);
        if (administratorSelected==null){
            administratorService.createOrUpdate(administratorSelected);
            AdministratorDTO administratorDTO = new AdministratorDTO();
            administratorDTO.setMsg("success");
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
    public AdministratorDTO creatClass(@RequestBody Class creatClass) {

        return null;
    }

}
