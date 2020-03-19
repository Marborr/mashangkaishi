package life.mashangkaishi.manongcommunity.dto;

import lombok.Data;

@Data
public class TaskAndPageDTO  {
    String TaskName;
    String Teacher;
    String StuId;
    int page;
    int limit;
}
