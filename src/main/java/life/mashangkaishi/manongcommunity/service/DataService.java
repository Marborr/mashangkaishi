package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.DataExtMapper;
import life.mashangkaishi.manongcommunity.mapper.DataMapper;
import life.mashangkaishi.manongcommunity.model.Data;
import life.mashangkaishi.manongcommunity.model.DataExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DataService {
    @Autowired
    DataMapper dataMapper;
    @Autowired
    DataExtMapper dataExtMapper;

    public String creatOrUpdateData(Data data){
        data.setDataId(dataExtMapper.selectDataNumber(data)+1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        data.setGmtCreate(df.format(new Date()));
        dataMapper.insert(data);
        return "数据更新成功";
    }

}
