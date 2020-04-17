package life.mashangkaishi.manongcommunity.service;

import life.mashangkaishi.manongcommunity.mapper.JobsMapper;
import life.mashangkaishi.manongcommunity.model.Jobs;
import life.mashangkaishi.manongcommunity.model.JobsExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JobService {
    @Autowired
    JobsMapper jobsMapper;
    public ArrayList<Jobs> getJobs(int page, int limit){
        Integer offset = limit * (page - 1);//页面偏移量
        JobsExample example = new JobsExample();
        return (ArrayList<Jobs>) jobsMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, limit));
    }

}
