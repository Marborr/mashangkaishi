package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.PageDTO;
import life.mashangkaishi.manongcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index() {

//        HttpServletRequest request,
//        Model model,
//        @RequestParam(name = "page", defaultValue = "1") Integer page,
//        @RequestParam(name = "size", defaultValue = "5") Integer size,
//        @RequestParam(name = "search", required = false) String search

//        PageDTO pageDTO = questionService.list(search,page,size);
//
//        model.addAttribute("pagination", pageDTO);
//        model.addAttribute("search",search);
        return "login";
    }
}