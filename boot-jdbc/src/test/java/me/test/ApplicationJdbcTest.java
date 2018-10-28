package me.test;

import com.blue.ApplicationJdbc;
import com.blue.Service.UserService;
import com.blue.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tool.help.Zhou_String;
import tool.help.Zhou_Word;

import javax.sql.DataSource;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/27
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationJdbc.class})
public class ApplicationJdbcTest {
    private final Logger logger  = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;


    @Test
    public void add(){
        User user = new User();
        user.setPassword(Zhou_String.toLowerCase(6));
        user.setId(UUID.randomUUID().toString());
        user.setBirthday(new Date());
        user.setName(Zhou_Word.getChineseName());
        user.setUsername(Zhou_String.toOther(7));
        user.setPassword(Zhou_String.toOther(7));
        user.setAddress("china");
        user.setSex("man");
        user.setJurisdiction(String.valueOf(System.currentTimeMillis()));
        user.setPermission(String.valueOf(System.currentTimeMillis()));
        user.setRole(String.valueOf(System.currentTimeMillis()));
        user.setAge(new Random(System.currentTimeMillis()).nextInt());
        user.setAccount(UUID.randomUUID().toString());
        user.setGroup(UUID.randomUUID().toString());
        user.setCreateDate(new Date());
        user.setCreate(user.getName());
        logger.info(user.toString());
        try {
            userService.addUser(user);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        }
    }
}
