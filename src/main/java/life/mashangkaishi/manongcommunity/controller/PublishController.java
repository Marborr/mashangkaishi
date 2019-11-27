package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.mapper.QuesstionMapper;
import life.mashangkaishi.manongcommunity.mapper.UserMapper;
import life.mashangkaishi.manongcommunity.model.Quesstion;
import life.mashangkaishi.manongcommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuesstionMapper quesstionMapper;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model) {
        User user=null;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie c : cookies) {
                if (c.getName().equals("token")){
                    String token = c.getValue();
                    user=userMapper.findByToken(token);
                    if (user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }
        if (user==null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }
        Quesstion quesstion=new Quesstion();
        quesstion.setTitle(title);
        quesstion.setDescription(description);
        quesstion.setTag(tag);
        quesstion.setCreator(user.getId());
        quesstion.setGmtCreate(System.currentTimeMillis());
        quesstion.setGmtModified(quesstion.getGmtCreate());
        return "redirect:/";
    }
}
