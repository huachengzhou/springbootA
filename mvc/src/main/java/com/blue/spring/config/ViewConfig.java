package com.blue.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/
@Configuration
public class ViewConfig {

    /**
     * 通过注解@Bean 初始化视图解析器
     * @return
     */
    @Bean
    public ViewResolver initViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 初始化 RequestMappingHandlerAdapter , 并加载HTTP 的 JSON 转换器
     * @return
     */
    @Bean
    public HandlerAdapter initRequestMappingHandlerAdapter(){
        //创建 RequestMappingHandlerAdapter 适配器
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        //HTTP JSON转换器
        MappingJackson2HttpMessageConverter jackson2MessageConverter = new MappingJackson2HttpMessageConverter();
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> mediaTypes = new ArrayList<MediaType>(2);
        //加入转换器支持类型
        mediaTypes.add(mediaType);
        //给适配器加入JSON转换器
        jackson2MessageConverter.setSupportedMediaTypes(mediaTypes);
        adapter.getMessageConverters().add(jackson2MessageConverter);
        return adapter;
    }
}
