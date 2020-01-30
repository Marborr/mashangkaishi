package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Task;
import org.springframework.stereotype.Component;

@Component
public interface TaskExtMapper {
    Integer selectTaskNumber(Task task);
}
