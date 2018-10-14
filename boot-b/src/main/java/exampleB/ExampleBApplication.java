package exampleB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.Charset;

/**
 * @Author zch
 * @Description spring boot
 * @createDate 2018/10/14
 **/

@RequestMapping(value = "/example")
@Controller
@SpringBootApplication(exclude = { RedisAutoConfiguration.class })
@Configuration
public class ExampleBApplication {
    private static final Logger logger = LoggerFactory.getLogger(ExampleBApplication.class);

    @RequestMapping(value = "/hello",name = "http://localhost:8090/example/hello 浏览器输入即可")
    @ResponseBody
    public String hello() {
        return "spring boot 例子学习";
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ExampleBApplication.class);
        application.setBannerMode(Banner.Mode.CONSOLE);
        logger.info("test");
        application.run(args);
    }

}
