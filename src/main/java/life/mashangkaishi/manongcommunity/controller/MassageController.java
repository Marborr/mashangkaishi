package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.Mes;
import life.mashangkaishi.manongcommunity.model.Task;
import life.mashangkaishi.manongcommunity.model.systemMessage;
import life.mashangkaishi.manongcommunity.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MassageController {
    @Autowired
    MassageService massageService;

//    @Transactional
//    @ResponseBody
//    @PostMapping("/api/user/MassagePush")
//    public List<Task> MassagePush(@RequestBody systemMessage message) {
//        massageService.pushMassage(message);
//        Mes
//        return tasks;
//    }
}
