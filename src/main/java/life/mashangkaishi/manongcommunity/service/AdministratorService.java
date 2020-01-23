package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.AdministratorExtMapper;
import life.mashangkaishi.manongcommunity.mapper.AdministratorMapper;
import life.mashangkaishi.manongcommunity.model.Administrator;
import life.mashangkaishi.manongcommunity.model.AdministratorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    AdministratorExtMapper administratorExtMapper;
    public Administrator selectAdministrator(Administrator administrator) {
           AdministratorExample example=new AdministratorExample();
            example.createCriteria().andUsernameEqualTo(administrator.getUsername());
            List<Administrator> administrators = administratorMapper.selectByExample(example);
            if (administrators.size()==0){
                return null;
            }
            return administrators.get(0);
    }

    public Administrator createOrUpdate(Administrator administrator) {
        if (administrator.getId()==null){
            administrator.setId(administratorExtMapper.selectAdministratorNumber(administrator)+1);//查询所有老师的总数
        }
        AdministratorExample example=new AdministratorExample();
        example.createCriteria().andUsernameEqualTo(administrator.getUsername());
        List<Administrator> administrators = administratorMapper.selectByExample(example);
        if(administrators.size() ==0){
            //插入
            administrator.setGmtCreate((int)System.currentTimeMillis());
            administratorMapper.insert(administrator);
            return administrator;
        }else {
            //更新
            Administrator dbAdministrator = administrators.get(0);
            if (dbAdministrator.getVerification()!=null ||dbAdministrator.getVerification()==administrator.getVerification())
            {
                dbAdministrator.setPassword(administrator.getPassword());
            }
            dbAdministrator.setVerification(administrator.getVerification());
            AdministratorExample example1 = new AdministratorExample();
            example1.createCriteria().andIdEqualTo(dbAdministrator.getId());
            administratorMapper.updateByExampleSelective(dbAdministrator, example1);
            return dbAdministrator;
        }
    }
}
