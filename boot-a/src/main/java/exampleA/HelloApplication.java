package exampleA;

import java.nio.charset.Charset;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //标明这是一个SpringMVC的Controller控制器
@SpringBootApplication(exclude = { RedisAutoConfiguration.class })//Spring Boot项目的核心注解，主要目的是开启自动配置
@Configuration//这是一个配置Spring的配置类；
public class HelloApplication {

    @RequestMapping(value = "hello",name = "http://localhost:8080/hello 浏览器输入即可")
    @ResponseBody
    public String hello() {
        return "hello world! ";
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
        return converter;
    }

    //main方法：在main方法中启动一个应用，即：这个应用的入口；
    public static void main(String[] args) {
        // SpringApplication.run(HelloApplication.class, args);
        SpringApplication application = new SpringApplication(HelloApplication.class);
        application.setBannerMode(Mode.CONSOLE);// banner 处理
        application.run(args);
    }

}
