package life.mashangkaishi.manongcommunity.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncExecutors {
    @Value("${async.thread.core.pool:8}")
    private int asyncCorePoolSize;

    @Value("${async.thread.Max.pool:64}")
    private int asyncMaxPoolSize;

    @Value("${async.queue.capacity.pool:1000}")
    private int asyncQueueCapacity;

    @Bean
    public Executor asyncExecutor(){
        ThreadPoolTaskExecutor threadPoolExecutor=new ThreadPoolTaskExecutor();
        threadPoolExecutor.setThreadNamePrefix("async-pool-");
        threadPoolExecutor.setCorePoolSize(asyncCorePoolSize);
        threadPoolExecutor.setMaxPoolSize(asyncMaxPoolSize);
        threadPoolExecutor.setQueueCapacity(asyncQueueCapacity);
        return threadPoolExecutor;
    }
}
