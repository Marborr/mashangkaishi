package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.mailIdentifyMapper;
import life.mashangkaishi.manongcommunity.model.mailIdentify;
import life.mashangkaishi.manongcommunity.model.mailIdentifyExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {
    @Autowired
    mailIdentifyMapper mailIdentifyMapper;

    @Async
    public void InsertData(String email, String identify) {
        mailIdentify mailIdentify = new mailIdentify();
        mailIdentify.setEmail(email);
        mailIdentify.setIdentifyNumber(identify);
        mailIdentifyMapper.insert(mailIdentify);

        try {
            Thread.sleep(6000*1000);
            mailIdentifyExample example = new mailIdentifyExample();
            example.createCriteria().andEmailEqualTo(email);
            mailIdentifyMapper.deleteByExample(example);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
