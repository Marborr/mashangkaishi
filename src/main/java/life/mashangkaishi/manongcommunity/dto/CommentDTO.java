package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.User;
import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Integer commentCount;
    private Long commentator;
    private Long gmtCreat;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
}
