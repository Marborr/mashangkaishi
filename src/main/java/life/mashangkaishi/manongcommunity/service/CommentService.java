package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.CommentDTO;
import life.mashangkaishi.manongcommunity.enums.CommentTypeEnum;
import life.mashangkaishi.manongcommunity.enums.NotificationStatusEnum;
import life.mashangkaishi.manongcommunity.enums.NotificationTypeEnum;
import life.mashangkaishi.manongcommunity.exception.CustomizeErrorCode;
import life.mashangkaishi.manongcommunity.exception.CustomizeException;
import life.mashangkaishi.manongcommunity.mapper.*;
import life.mashangkaishi.manongcommunity.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionExtMapper questionExtMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentExtMapper commentExtMapper;
    @Autowired
    private NotificationMapper notificationMapper;

    //事务
    @Transactional
    public void insert(Comment comment, User commentator) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {
            throw new CustomizeException(CustomizeErrorCode.TARGET_PARAM_NOT_FOUND);
        }

        if (comment.getType() == null || !CommentTypeEnum.isExist(comment.getType())) {
            throw new CustomizeException(CustomizeErrorCode.TYPE_PARAM_WRONG);
        }

        if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            //回复评论
            Comment dbComment = commentMapper.selectByPrimaryKey(comment.getParentId());
            if (dbComment == null) {
                throw new CustomizeException(CustomizeErrorCode.COMMENT_NOT_FOUND);
            }

            //回复问题
            Question question = questionMapper.
                    selectByPrimaryKey(dbComment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            commentMapper.insert(comment);
            //增加评论数
            Comment parentComment =new Comment();
            parentComment.setId(comment.getParentId());
            parentComment.setCommentCount(1);
            commentExtMapper.incCommentCount(parentComment);
            //创建通知
            creatNotify(comment, dbComment.getCommentator(), commentator.getName(), question.getTitle(), NotificationTypeEnum.REPLY_COMMENT, question.getId());
        } else {
            //回复问题
            Question question = questionMapper.
                    selectByPrimaryKey(comment.getParentId());
            if (question == null) {
                throw new CustomizeException(CustomizeErrorCode.QUESTION_NOT_FOUND);
            }
            comment.setCommentCount(0);
            commentMapper.insert(comment);
            question.setCommentCount(1);
            questionExtMapper.incCommentCount(question);
            //创建通知
            creatNotify(comment,question.getCreator(),commentator.getName(),question.getTitle(), NotificationTypeEnum.REPLY_QUESTION, question.getId());
        }

    }

    private void creatNotify(Comment comment, Long receiver, String notifierName, String outerTitle, NotificationTypeEnum notificationType, Long outId) {
        //如果是自己评论回复自己的内容，则无需通知
        if (receiver == comment.getCommentator()){
            return ;
        }
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setType(notificationType.getType());
        notification.setOuterid(outId);
        notification.setNotifier(comment.getCommentator());
        notification.setStatus(NotificationStatusEnum.UNREAD.getStatus());
        notification.setReceiver(receiver);
        notification.setNotifierName(notifierName);
        notification.setOuterTitle(outerTitle);
        notificationMapper.insert(notification);
    }

    public List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type) {
        CommentExample example = new CommentExample();
        example.createCriteria().
                andParentIdEqualTo(id).
                andTypeEqualTo(type.getType());
        example.setOrderByClause("gmt_creat desc");//按创建时间的倒序排序

        List<Comment> commentList = commentMapper.selectByExample(example);

        if (commentList.size()==0){
            return new ArrayList<>();
        }
        //所有评论者(除去了重复id)
        Set<Long> commentors = commentList.stream().map(comment -> comment.getCommentator()).collect(Collectors.toSet());
        List<Long> usersnumber=new ArrayList<>();
        usersnumber.addAll(commentors);

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andIdIn(usersnumber);
        List<User> users = userMapper.selectByExample(userExample);
        //将users做成map，方便读取(jdk8特性）
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(user -> user.getId(), user -> user));
        //转换Comment为CommentDTO
        List<CommentDTO> commentDTOs = commentList.stream().map(comment -> {
            CommentDTO commentDTO = new CommentDTO();
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(userMap.get(comment.getCommentator()));
            return commentDTO;
        }).collect(Collectors.toList());

        return commentDTOs;
    }
}
