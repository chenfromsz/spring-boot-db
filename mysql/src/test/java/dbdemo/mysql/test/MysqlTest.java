package dbdemo.mysql.test;

import dbdemo.mysql.Application;
import dbdemo.mysql.config.JpaConfiguration;
import dbdemo.mysql.entity.Department;
import dbdemo.mysql.entity.Role;
import dbdemo.mysql.entity.User;
import dbdemo.mysql.repository.DepartmentRepository;
import dbdemo.mysql.repository.RoleRepository;
import dbdemo.mysql.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class, Application.class})
@SpringBootTest
public class MysqlTest {
    private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

    @Autowired
    UserRepository userRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    RoleRepository roleRepository;

    @Before
    public void initData(){
        userRepository.deleteAll();
        roleRepository.deleteAll();
        departmentRepository.deleteAll();

        Department department = new Department();
        department.setName("开发部");
        departmentRepository.save(department);
        Assert.notNull(department.getId(), "create department error");

        Role role = new Role();
        role.setName("admin");
        roleRepository.save(role);
        Assert.notNull(role.getId(), "create role error");

        User user = new User();
        user.setName("user");
        user.setCreatedate(new Date());
        user.setDeparment(department);

        List<Role> roles = roleRepository.findAll();
        Assert.notNull(roles, "find roles error");
        user.setRoles(roles);

        userRepository.save(user);
        Assert.notNull(user.getId(), "create user error");
    }

    @Test
    public void findPage(){
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.notNull(page, "find page error");
        for(User user : page.getContent()) {
            logger.info("====user==== user name:{}, department name:{}, role name:{}",
                    user.getName(), user.getDeparment().getName(), user.getRoles().get(0).getName());
        }
    }

    //@Test
    public void test(){
        User user1 = userRepository.findByNameLike("u%");
        Assert.notNull(user1, "find user1 error");

        User user2 = userRepository.readByName("user");
        Assert.notNull(user2, "find user2 error");

        List<User> users = userRepository.getByCreatedateLessThan(new Date());
        Assert.notNull(users, "find user list error");
    }
}
