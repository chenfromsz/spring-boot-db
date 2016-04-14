package dbdemo.mongo.test;


import dbdemo.mongo.models.User;
import dbdemo.mongo.repositories.UserRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataSourceConfig.class})
@FixMethodOrder
public class RepositoryTests {
	private static Logger logger = LoggerFactory.getLogger(RepositoryTests.class);
	
	@SuppressWarnings("SpringJavaAutowiringInspection") @Autowired
	UserRepository userRepository;
	
	@Before
	public void setup(){
		Set<String> roles = new HashSet<>();
		roles.add("manage");
		User user = new User("1","user","12345678","name","email@com.cn",new Date(), roles);
		userRepository.save(user);
	}
	
	@Test
	public void findAll(){
		List<User> users = userRepository.findAll();
		Assert.notNull(users);
		for(User user : users){
			logger.info("===user=== userid:{}, username:{}, pass:{}, registrationDate:{}",
					user.getUserId(), user.getName(), user.getPassword(), user.getRegistrationDate());
		}
	}
}

//	> db.user.find()
//	{ "_id" : "1", "_class" : "dbdemo.mongo.models.User", "username" : "user", "pass
//		word" : "12345678", "name" : "name", "email" : "email@com.cn", "registrationDate
//		" : ISODate("2016-04-13T06:27:02.423Z"), "roles" : [ "manage" ] }