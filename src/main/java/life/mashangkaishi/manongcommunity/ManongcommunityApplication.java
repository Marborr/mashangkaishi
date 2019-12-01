package life.mashangkaishi.manongcommunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("life.mashangkaishi.manongcommunity.mapper")
public class ManongcommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManongcommunityApplication.class, args);
    }
}
