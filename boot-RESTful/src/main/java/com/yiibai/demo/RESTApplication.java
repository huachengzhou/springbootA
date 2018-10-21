package com.yiibai.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/21
 **/
@SpringBootApplication
public class RESTApplication {

    private static final Logger logger = LoggerFactory.getLogger(RESTApplication.class);

    public static void main(String[] args) {
        logger.info("start!");
        new SpringApplication(RESTApplication.class).run(args);
        logger.info("end!");
    }

    /**
     * 跨域
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/products").allowedOrigins("http://localhost:8080");
            }
        };
    }
}
