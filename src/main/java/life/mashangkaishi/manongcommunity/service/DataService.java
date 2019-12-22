package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.DataExtMapper;
import life.mashangkaishi.manongcommunity.mapper.DataMapper;
import life.mashangkaishi.manongcommunity.model.Data;
import life.mashangkaishi.manongcommunity.model.DataExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {
    @Autowired
    DataMapper dataMapper;
    @Autowired
    DataExtMapper dataExtMapper;

    public String creatOrUpdateData(Data data){
        data.setDataId(dataExtMapper.selectDataNumber(data)+1);
        data.setGmtCreate((int) System.currentTimeMillis());
        dataMapper.insert(data);
        return "数据更新成功";
    }

}
