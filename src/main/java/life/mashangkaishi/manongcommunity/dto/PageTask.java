package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class PageTask {
    List<Task> tasks;
    int allTasks;
}
