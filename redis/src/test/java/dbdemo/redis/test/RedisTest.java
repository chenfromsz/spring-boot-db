package dbdemo.redis.test;


import dbdemo.mysql.entity.Department;
import dbdemo.mysql.entity.Role;
import dbdemo.mysql.entity.User;
import dbdemo.redis.repository.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    UserRedis userRedis;

    @Before
    public void setup(){
        Department deparment = new Department();
        deparment.setName("开发部");

        Role role = new Role();
        role.setName("admin");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(deparment);

        List<Role> roles = new ArrayList<>();
        roles.add(role);

        user.setRoles(roles);

        userRedis.delete(this.getClass().getName()+":userByname:"+user.getName());
        userRedis.add(this.getClass().getName()+":userByname:"+user.getName(), 10L, user);

    }

    @Test
    public void get(){
        User user = userRedis.get(this.getClass().getName() + ":userByname:user");
        Assert.notNull(user);
        logger.info("======user====== name:{}, deparment:{}, role:{}",
                user.getName(), user.getDeparment().getName(), user.getRoles().get(0).getName());
    }
}
