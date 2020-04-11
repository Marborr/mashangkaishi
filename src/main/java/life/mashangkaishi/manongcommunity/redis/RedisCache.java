package life.mashangkaishi.manongcommunity.redis;

import life.mashangkaishi.manongcommunity.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    private String id;


    public RedisCache(String id){
        System.out.println(id);
        this.id=id;
    }



    @Override
    public String getId() {
        return id;
    }

    //放入缓存
    @Override
    public void putObject(Object key, Object value) {
        //获取redisTemplate对象
        RedisTemplate redisTemplate =(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //序列化key，可不加
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //存储缓存数据
        redisTemplate.opsForValue().set(key.toString(),value);
    }

    //在缓存中获取
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate =(RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        //存储缓存数据
        System.out.println(key.toString());
        System.out.println(redisTemplate.opsForValue().get(key.toString()));
        return redisTemplate.opsForValue().get(key.toString());
    }

    //删除缓存中的数据
    @Override
    public Object removeObject(Object o) {
        return null;
    }

    //清空缓存
    @Override
    public void clear() {

    }

    //缓存命中率
    @Override
    public int getSize() {
        return 0;
    }

    //读写锁 读写互斥 读读不互斥
    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

}
