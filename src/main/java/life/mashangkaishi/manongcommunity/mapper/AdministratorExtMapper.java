package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Administrator;
import org.springframework.stereotype.Component;

@Component
public interface AdministratorExtMapper {
    int selectAdministratorNumber(Administrator administrator);
}