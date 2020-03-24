package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.dto.MassageInDTO;
import life.mashangkaishi.manongcommunity.dto.MassagePageDTO;
import life.mashangkaishi.manongcommunity.mapper.systemMessageMapper;
import life.mashangkaishi.manongcommunity.model.systemMessage;
import life.mashangkaishi.manongcommunity.model.systemMessageExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MassageService {
    @Autowired
    systemMessageMapper systemMessageMapper;

    public int pushMassage(systemMessage message) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setCreatTime(df.format(new Date()));
        int insert = systemMessageMapper.insert(message);
        return insert;
    }

    public MassagePageDTO selectMassage(MassageInDTO message) {
        MassagePageDTO massagePageDTO = new MassagePageDTO();
        systemMessageExample example = new systemMessageExample();
        systemMessageExample example2 = new systemMessageExample();
        example.createCriteria().andCreatTimeIsNotNull();
        example2.createCriteria().andCreatTimeIsNotNull();
        Integer offset = message.getLimit() * (message.getPage() - 1);//页面偏移量

        List<systemMessage> systemMessages = systemMessageMapper.selectByExampleWithBLOBsWithRowbounds
                (example, new RowBounds(offset, message.getLimit()));
        List<systemMessage> systemMessages2 = systemMessageMapper.selectByExample(example2);
        int integer=systemMessages2.size();
        if (message.getLimit() != 0){
            if (integer % message.getLimit() != 0)
                integer = integer / message.getLimit() + 1;
            else
                integer = integer / message.getLimit();
        }
        massagePageDTO.setMessages(systemMessages);
        massagePageDTO.setMegPages(integer);
        return massagePageDTO;
    }
}
