package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.AdministratorExtMapper;
import life.mashangkaishi.manongcommunity.mapper.AdministratorMapper;
import life.mashangkaishi.manongcommunity.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    AdministratorExtMapper administratorExtMapper;
    @Autowired
    life.mashangkaishi.manongcommunity.mapper.mailIdentifyMapper mailIdentifyMapper;

    public Administrator selectAdministrator(Administrator administrator) {
        AdministratorExample example = new AdministratorExample();
        example.createCriteria().andTeacherIdEqualTo(administrator.getTeacherId())
                .andPasswordEqualTo(administrator.getPassword());
        List<Administrator> administrators = administratorMapper.selectByExample(example);
        if (administrators.size() == 0) {
            return null;
        } else {
            return administrators.get(0);
        }
    }

    public Administrator selectAdministratorByTecherId(Administrator administrator) {
        AdministratorExample example = new AdministratorExample();
        example.createCriteria().andTeacherIdEqualTo(administrator.getTeacherId());
        List<Administrator> administrators = administratorMapper.selectByExample(example);
        if (administrators.size() == 0) {
            return null;
        } else {
            return administrators.get(0);
        }
    }

    public String create(Administrator administrator) {
        mailIdentifyExample mailexample = new mailIdentifyExample();
        mailexample.createCriteria().andEmailEqualTo(administrator.getEmail());
        List<mailIdentify> mailIdentifies
                = mailIdentifyMapper.selectByExample(mailexample);
        if (mailIdentifies.size() == 0) {
            return "验证码有误";
        }
        if (String.valueOf(administrator.getVerification()).equals(mailIdentifies.get(mailIdentifies.size() - 1).getIdentifyNumber())) {

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            //插入
            administrator.setGmtCreate(df.format(new Date()));
            administrator.setIdentify("teacher");
            administratorMapper.insert(administrator);
            return "创建成功";
        } else
            return "验证码有误";
    }

    public String Update(Administrator administrator) {
        Administrator administrator1 = selectAdministratorByTecherId(administrator);

        mailIdentifyExample mailexample = new mailIdentifyExample();
        mailexample.createCriteria().andEmailEqualTo(administrator.getEmail());
        List<mailIdentify> mailIdentifies
                = mailIdentifyMapper.selectByExample(mailexample);
        if (mailIdentifies.size() == 0) {
            return "验证码有误";
        }
        if (String.valueOf(administrator.getVerification()).equals(mailIdentifies.get(mailIdentifies.size() - 1).getIdentifyNumber())) {

            AdministratorExample example1 = new AdministratorExample();
            example1.createCriteria().andIdEqualTo(administrator1.getId());
            administratorMapper.updateByExampleSelective(administrator, example1);
            return "更新成功";
        } else
            return "验证码有误";
    }
}
