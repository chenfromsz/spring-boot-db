package dbdemo.redis.test;

import dbdemo.redis.Application;
import dbdemo.redis.config.RedisConfig;
import dbdemo.redis.models.User;
import dbdemo.redis.service.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, Application.class})
@SpringBootTest
public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private RedisService<User> userService;

    @Before
    public void setup(){

        Set<String> roles = new HashSet<>();
        roles.add("manage");
        User user = new User("123456", "user", new Date(), roles);

        userService.delete(this.getClass().getName(),":userid:"+user.getUserId());

        userService.add(this.getClass().getName(),":userid:"+user.getUserId(), user);

    }

    @Test
    public void get(){
        User user = userService.get(this.getClass().getName(), ":userid:123456");
        Assert.notNull(user, "get error");
        logger.info("======user====== userid:{}, username:{}, role:{}",
                user.getUserId(), user.getUsername(), user.getRoles().iterator().next());
    }
}
