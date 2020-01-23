package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Comment;
import org.springframework.stereotype.Component;
@Component
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}