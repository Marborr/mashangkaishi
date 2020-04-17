package life.mashangkaishi.manongcommunity.schedule;

import life.mashangkaishi.manongcommunity.dto.Job;
import life.mashangkaishi.manongcommunity.mapper.JobsMapper;
import life.mashangkaishi.manongcommunity.model.Jobs;
import life.mashangkaishi.manongcommunity.util.Spider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
@Slf4j
public class ScheduleTask {
    @Autowired
    Spider spider;
    @Autowired
    JobsMapper jobsMapper;

    //@Scheduled(cron = "0 0 5 ? * MON")//周一5点执行
    //@Scheduled(fixedRate = 3000)//周一5点执行
    public void reportCurrentTime() {
        log.info("The time is now {}", new Date());
    }
    //Logger log = LoggerFactory.getLogger(SchedulerTask.class);

    //cron表达式：每隔5秒执行一次
    @Scheduled(cron = "0 0 5 ? * *")
    public void scheduled() {
        ArrayList<Job> jobs = spider.getJobs();
        //jobsMapper.selectByExample()
        for (Job job:jobs){
            Jobs j=new Jobs();
            j.setCompany(job.getCompany());
            j.setJobName(job.getJobname());
            j.setMoney(job.getMoney());
            j.setTime(job.getTime());
            j.setUrl(job.getUrl());
            j.setScale(job.getScale());
            jobsMapper.insert(j);
        }
        log.info("使用cron: {}");
    }

    //@Scheduled(fixedRate = 5000)//周一5点执行
    public void CurrentTime() {
        log.info("time {}", new Date());
    }

}
