package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.dto.TaskAndPageDTO;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Task;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskExtMapper {
    Integer selectTaskNumber();
    List<Task> selectByExampleWithBLOBsLimit(TaskAndPageDTO taskAndPageDTO);
}
