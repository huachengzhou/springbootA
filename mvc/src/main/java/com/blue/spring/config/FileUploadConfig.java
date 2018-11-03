package com.blue.spring.config;

import com.blue.spring.ince.CustomMultipartResolver;
import com.blue.spring.ince.FileUploadProgressListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/

@Configuration
public class FileUploadConfig {

    /**
     * 文件上传监听器
     * @return
     */
    @Bean(name = "fileUploadProgressListener")
    public FileUploadProgressListener initUploadProgressListener(){
        return new FileUploadProgressListener();
    }

    /**
     *  文件上传配置
     * @param fileUploadProgressListener
     * @return
     */
    @Bean(name = "customMultipartResolver")
    public CustomMultipartResolver initCommonsMultipartResolver(@Qualifier(value = "fileUploadProgressListener") FileUploadProgressListener fileUploadProgressListener){
        CustomMultipartResolver multipartResolver = new CustomMultipartResolver(fileUploadProgressListener);
        multipartResolver.setDefaultEncoding("UTF-8");
        multipartResolver.setMaxInMemorySize(121638400);
        return multipartResolver ;
    }

}
