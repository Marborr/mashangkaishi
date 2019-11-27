package life.mashangkaishi.manongcommunity.mapper;

import life.mashangkaishi.manongcommunity.model.Quesstion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface QuesstionMapper {
    @Insert("insert into (title,description,gmt_creat,gmt_modified,creator,tag) values (#{title},#{description},#{gmt_creat},#{gmt_modified},#{creator},#{tag})")
    void create(Quesstion quesstion);
}
