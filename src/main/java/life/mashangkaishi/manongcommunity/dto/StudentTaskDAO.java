package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class StudentTaskDAO {
    List<Class> classes;
    List<Task> tasks;
}
