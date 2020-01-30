package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Class;
import org.springframework.stereotype.Component;

@Component
public interface ClassExtMapper {
    Integer selectClassNumber(Class classNumber);
}
