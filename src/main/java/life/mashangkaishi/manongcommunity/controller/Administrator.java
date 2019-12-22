package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.AdministratorDTO;
import life.mashangkaishi.manongcommunity.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Administrator {
    @Autowired
    AdministratorService administratorService;

    @Transactional
    @ResponseBody
    @PostMapping("/api/user/administratorRegister")
    public AdministratorDTO regist(@RequestBody Administrator administrator) {
        Administrator administratorSelected = administratorService.selectStudent(administrator);
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
}
