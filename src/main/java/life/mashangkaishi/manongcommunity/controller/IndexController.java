package life.mashangkaishi.manongcommunity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

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