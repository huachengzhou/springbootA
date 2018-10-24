package cn.blue.test;

import com.blue.spring.ApplicationStart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationStart.class})
public class BBTestAA {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Qualifier(value = "boneCPDataSource")
    @Autowired
    private DataSource boneCPDataSource;

    @Test
    public void jdbcTest(){
        logger.info(boneCPDataSource.toString());
    }
}
