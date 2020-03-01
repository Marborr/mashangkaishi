package life.mashangkaishi.manongcommunity.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class ScheduleTask {
    //@Scheduled(cron = "0 0 5 ? * MON")//周一5点执行
    //@Scheduled(fixedRate = 3000)//周一5点执行
    public void reportCurrentTime() {
        log.info("The time is now {}", new Date());
    }

    //@Scheduled(fixedRate = 5000)//周一5点执行
    public void CurrentTime() {
        log.info("time {}", new Date());
    }

}
