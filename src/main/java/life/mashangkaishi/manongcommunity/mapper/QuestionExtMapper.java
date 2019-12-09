package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.dto.QuestionQueryDTO;
import life.mashangkaishi.manongcommunity.model.Question;
import life.mashangkaishi.manongcommunity.model.QuestionExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QuestionExtMapper {
    int incView(Question record);
    int incCommentCount(Question record);
    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}