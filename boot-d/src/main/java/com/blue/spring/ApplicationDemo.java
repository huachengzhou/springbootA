package com.blue.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/28
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages = {"com.blue.spring.config","com.blue.dal.dao","com.blue.dal.mapper"})
public class ApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class, args);
    }
}
