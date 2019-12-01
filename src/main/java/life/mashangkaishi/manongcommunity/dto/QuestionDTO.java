package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Integer id;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private User user;
}
