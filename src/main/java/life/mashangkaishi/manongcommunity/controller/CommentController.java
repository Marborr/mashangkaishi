package life.mashangkaishi.manongcommunity.controller;

import life.mashangkaishi.manongcommunity.dto.CommentCreateDTO;
import life.mashangkaishi.manongcommunity.dto.CommentDTO;
import life.mashangkaishi.manongcommunity.dto.ResultDTO;
import life.mashangkaishi.manongcommunity.enums.CommentTypeEnum;
import life.mashangkaishi.manongcommunity.exception.CustomizeErrorCode;
import life.mashangkaishi.manongcommunity.model.Comment;
import life.mashangkaishi.manongcommunity.model.User;
import life.mashangkaishi.manongcommunity.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//前后端分离模式

/**
 * 接口类型
 *
 * 传入：（post）
 * “parentId":long（该被评论类容的ID）
 * "content':“回复类容”
 * “type”：int（1 或者 2）(此处为父类评论类型，父类可以直接是问题，也可以是评论，即对评论再进行评论）
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())) {
            return ResultDTO.errorOf(CustomizeErrorCode.COMMENT_IS_EMPTY);
        }

        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreat(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment,user);
        return ResultDTO.OkOf();
    }
    @ResponseBody
    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public ResultDTO<List> commments(@PathVariable(name = "id") Long id){
        List<CommentDTO> commentDTOS = commentService.listByTargetId(id, CommentTypeEnum.COMMENT);
        return ResultDTO.OkOf(commentDTOS);
    }
}
