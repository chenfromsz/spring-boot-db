package dbdemo.redis.service;

import dbdemo.redis.models.User;
import dbdemo.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private RedisRepository redisRepository;

    public void add(String key1, String key2, User user) {
        redisRepository.put(key1, key2, user);
    }

    public User get(String key1, String key2) {
        User user = null;
        Object object = redisRepository.get(key1, key2);
        if(object != null){
            user = (User)object;
        }
        return user;
    }


    public void delete(String key1, String key2){
        redisRepository.remove(key1, key2);
    }
}
