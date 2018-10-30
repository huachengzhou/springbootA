package com.blue.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/28
 **/
@MapperScan("com.blue.dal.mapper")
@SpringBootApplication(scanBasePackages = {"com.blue"})
public class ApplicationDemo {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationDemo.class, args);
    }
}
