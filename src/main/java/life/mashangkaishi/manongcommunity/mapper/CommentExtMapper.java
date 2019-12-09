package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Comment;
import life.mashangkaishi.manongcommunity.model.CommentExample;
import life.mashangkaishi.manongcommunity.model.Question;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}