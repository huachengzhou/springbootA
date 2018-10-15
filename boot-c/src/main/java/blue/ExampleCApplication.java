package blue;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication(exclude = { RedisAutoConfiguration.class })
@Configuration
public class ExampleCApplication {

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        return "hello world！ 水浒传！";
    }

    /**
     * @Description:描述 消息转换器
     * @Author:zch
     * @CreateDate:22:20 2018/10/15
     * @Version:1.0
     */
    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        String charset = "UTF-8" ;
        charset = "ISO-8859-1" ;
        //乱码,实际上spring boot会自动配置为UTF-8
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName(charset));
        return converter;
    }

    public static void main(String[] args) {
        // SpringApplication.run(HelloApplication.class, args);
        SpringApplication application = new SpringApplication(ExampleCApplication.class);
        application.run(args);
    }

}
