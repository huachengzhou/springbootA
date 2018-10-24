package com.blue.spring.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/24
 **/
@ComponentScan(basePackages = "com.blue.spring.config")
@SpringBootApplication
public class ComponentScanConfig {

    public static void main(String[] args) {
        SpringApplication.run(ComponentScanConfig.class,args );
    }
}