package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/21
 **/
@SpringBootApplication
public class DemoExampleB1 {
    protected static final Logger logger = LoggerFactory.getLogger(DemoExampleB1.class);

    public static void main(String[] args) {
        logger.info("SpringBoot开始加载");
        SpringApplication application = new SpringApplication(DemoExampleB1.class);
        logger.info(String.format("%s%s","test", UUID.randomUUID().toString()));
        application.run(args);
        logger.info("SpringBoot加载完毕");
    }
}
