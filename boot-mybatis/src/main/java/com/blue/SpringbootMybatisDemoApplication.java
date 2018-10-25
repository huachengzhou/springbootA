package com.blue;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/24
 **/
@SpringBootApplication
@MapperScan("com.blue.mapper")
public class SpringbootMybatisDemoApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        new SpringApplication().run(SpringbootMybatisDemoApplication.class,args);
    }
}
