package com.blue.ioc.config;

import com.blue.domin.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@PropertySource(value = "resources_properties/app.properties")
@Configuration
public class ExpressiveDiscConfig {

    @Autowired
    private Environment environment;
    //PropertyResolver 可以看到可以设置默认属性
    //T getProperty(String key, Class<T> targetType, T defaultValue) 数据不存在的时候可以设置默认值
    @Bean(name = "blankDisc")
    public BlankDisc getBlankDisc(){
        BlankDisc blankDisc = new BlankDisc();
        blankDisc.setArtist(environment.getProperty("disc.artist","Rattle and Hum"));
        blankDisc.setTitle(environment.getProperty("disc.title"));
        return blankDisc;
    }
}
