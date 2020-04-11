package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.Job;
import life.mashangkaishi.manongcommunity.dto.MassageInDTO;
import life.mashangkaishi.manongcommunity.dto.MassagePageDTO;
import life.mashangkaishi.manongcommunity.dto.Mes;
import life.mashangkaishi.manongcommunity.model.Task;
import life.mashangkaishi.manongcommunity.model.systemMessage;
import life.mashangkaishi.manongcommunity.service.MassageService;
import life.mashangkaishi.manongcommunity.util.Spider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MassageController {
    @Autowired
    MassageService massageService;
    @Autowired
    Spider spider;


    @ResponseBody
    @PostMapping("/api/user/MassagePush")
    public Mes MassagePush(@RequestBody systemMessage message) {
        int i = massageService.pushMassage(message);
        Mes mes = new Mes();
        mes.setErr(i);
        if (i==1){
            mes.setMsg("发布成功");
        }else
            mes.setMsg("发布失败，请重试");
        return mes;
    }


    @ResponseBody
    @PostMapping("/api/user/MassageSelect")
    public MassagePageDTO MassageSelect(@RequestBody MassageInDTO message) {
        MassagePageDTO massagePageDTO = massageService.selectMassage(message);
        return massagePageDTO;
    }

    @ResponseBody
    @GetMapping("/api/user/GetJobs")
    public Job getJob() {
      return  spider.getJobs();
    }


}
