package life.mashangkaishi.manongcommunity;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Data
public class 算法 {
    @Test
    public void 负载均衡(){
        String s1="2020-01-31 17:17:12";
        String s2="2020-02-01 17:17:12";
        System.out.println(s2.compareTo(s1));
    }
    @Test
    @Scheduled(fixedDelay = 5000)
    public void test1(){
        System.out.println(new Date());
    }
}
