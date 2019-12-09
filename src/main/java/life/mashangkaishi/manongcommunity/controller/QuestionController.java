package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.CommentDTO;
import life.mashangkaishi.manongcommunity.dto.QuestionDTO;
import life.mashangkaishi.manongcommunity.enums.CommentTypeEnum;
import life.mashangkaishi.manongcommunity.service.CommentService;
import life.mashangkaishi.manongcommunity.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;
    @GetMapping("/question/{id}")
    public String question(@PathVariable(name="id")Long id,
                           Model model){
        QuestionDTO questionDTO=questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments =commentService.listByTargetId(id, CommentTypeEnum.QUESTION);

        //累加阅读数
        questionService.inView(id);
        model.addAttribute("question",questionDTO);
        model.addAttribute("comments",comments);
        model.addAttribute("relateQuestions",relatedQuestions);
        return "question";
    }
}
