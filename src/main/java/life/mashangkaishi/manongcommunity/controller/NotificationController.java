package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.NotificationDTO;
import life.mashangkaishi.manongcommunity.dto.PageDTO;
import life.mashangkaishi.manongcommunity.enums.NotificationTypeEnum;
import life.mashangkaishi.manongcommunity.model.Notification;
import life.mashangkaishi.manongcommunity.model.User;
import life.mashangkaishi.manongcommunity.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{id}")
    public String profile(@PathVariable(name = "id") Long id,
                          HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null){
            return "redirect:/";
        }


        NotificationDTO notificationDTO = notificationService.read(id, user);
        if (NotificationTypeEnum.REPLY_COMMENT.getType() ==notificationDTO.getType()||
                NotificationTypeEnum.REPLY_QUESTION.getType() ==notificationDTO.getType())
        {
            return "redirect:/question/"+notificationDTO.getOuterid();
        }else {
            return "redirect:/";
        }

    }
}
