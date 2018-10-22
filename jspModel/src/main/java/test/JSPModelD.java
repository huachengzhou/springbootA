package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/22
 **/
@ComponentScan
@SpringBootApplication
public class JSPModelD extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JSPModelD.class);
    }

    public static void main(String[] args) {
        new SpringApplication().run(JSPModelD.class,args);
    }
}
