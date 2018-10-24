package com.blue.spring;

import com.blue.spring.config.ComponentScanConfig;
import org.springframework.boot.SpringApplication;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/10/24
 **/
public class ApplicationStart {


    public static void main(String[] args) {
        SpringApplication.run(ComponentScanConfig.class,args );
    }
}
