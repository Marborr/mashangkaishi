package life.mashangkaishi.manongcommunity.dto;

import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.Class;
import life.mashangkaishi.manongcommunity.model.Task;
import lombok.Data;

import java.util.List;

@Data
public class AdministratorDTO {
    String msg;
    Administrator administrator;
    Class classMessege;
    List<Class> classes;
    String className;
    Task task;
}
