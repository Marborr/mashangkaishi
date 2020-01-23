package life.mashangkaishi.manongcommunity;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Data
public class 算法 {
    @Test
    public void 负载均衡(){
        System.out.println("负载均衡");
    }
    @Test
    @Scheduled(fixedDelay = 5000)
    public void test1(){
        System.out.println(new Date());
    }
}
