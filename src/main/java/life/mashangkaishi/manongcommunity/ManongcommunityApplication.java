package life.mashangkaishi.manongcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("life.mashangkaishi.manongcommunity.mapper")
@EnableScheduling
@EnableAsync
public class ManongcommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManongcommunityApplication.class, args);
    }
}
