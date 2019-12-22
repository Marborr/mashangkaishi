package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Data;
import life.mashangkaishi.manongcommunity.model.Student;
import org.springframework.stereotype.Component;

@Component
public interface DataExtMapper {
    Long selectDataNumber(Data data);
}
