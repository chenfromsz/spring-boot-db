package dbdemo.redis.service;

import dbdemo.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService<T> {
    @Autowired
    private RedisRepository redisRepository;

    public void add(String key1, String key2, T t) {
        redisRepository.put(key1, key2, t);
    }

    public T get(String key1, String key2) {
        T t = null;
        Object object = redisRepository.get(key1, key2);
        if(object != null){
            t = (T)object;
        }
        return t;
    }


    public void delete(String key1, String key2){
        redisRepository.remove(key1, key2);
    }
}
