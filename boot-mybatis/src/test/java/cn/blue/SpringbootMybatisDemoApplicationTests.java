package cn.blue;

import com.blue.SpringbootMybatisDemoApplication;
import com.blue.entity.User;
import com.blue.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootMybatisDemoApplication.class})
public class SpringbootMybatisDemoApplicationTests {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void addUser(){
		User user = new User();
		user.setPassword(UUID.randomUUID().toString());
		user.setPhone(String.valueOf(new Random(200).nextInt(100)));
		user.setUserName(String.valueOf(System.currentTimeMillis()));
		try {
			userService.saveAndUpdate(user);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

}
