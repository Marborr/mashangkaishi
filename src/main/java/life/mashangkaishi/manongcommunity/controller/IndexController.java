package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index() {
        return "login";
    }
    @GetMapping("/student")
    public String student() {
        return "student";
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}