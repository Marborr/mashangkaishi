package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentExtMapper {
    Long selectStudentNumber(Student student);
}
