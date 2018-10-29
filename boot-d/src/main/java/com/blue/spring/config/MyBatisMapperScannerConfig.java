package com.blue.spring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zch
 * @Description  扫描mybatis的接口
 * @createDate 2018/10/29
 **/

@Configuration
@AutoConfigureAfter(MyBatisConfig.class)//因为这个对象的扫描，需要在MyBatisConfig的后面注入，所以加上下面的注解
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //指定xml配置文件的路径
        mapperScannerConfigurer.setBasePackage("com.blue.dal.mapper");
        return mapperScannerConfigurer;
    }
}
