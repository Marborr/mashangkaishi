package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Student;
import lombok.Data;

@Data
public class JoinClassDTO {
    String studentUsername;
    String className;
    int classNumber;
}
