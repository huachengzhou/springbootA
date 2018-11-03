package com.blue.ioc.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@PropertySource(value = {"classpath:resources_properties/db.properties","classpath:resources_properties/db_druid.properties"})
@Configuration
public class DataSourceConfig {
    private final long slowSqlMillis = 1000;

    @Resource
    private Environment env;

    @Bean(name = "comboPooledDataSource")
    public ComboPooledDataSource getComboPooledDataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
            comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
            comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            comboPooledDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("jdbc.minPoolSize")));
            comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("jdbc.initialPoolSize")));
            comboPooledDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("jdbc.maxPoolSize")));
            comboPooledDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("jdbc.maxIdleTime")));
        }catch (Exception e){
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }

    @Bean(name = "druidDataSource")
    public DruidDataSource getDruidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(getStatFilter());
        dataSource.setPassword(env.getProperty("druid.password"));
        dataSource.setUsername(env.getProperty("druid.user"));
        dataSource.setUrl(env.getProperty("druid.url"));
        dataSource.setDriverClassName(env.getProperty("druid.driverClassName"));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("druid.maxActive")));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("druid.initialSize")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("druid.minIdle")));
        dataSource.setMaxWait(Integer.parseInt(env.getProperty("druid.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("druid.minEvictableIdleTimeMillis")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("druid.maxPoolPreparedStatementPerConnectionSize")));
        dataSource.setProxyFilters(filters);
        return dataSource;
    }

    private StatFilter getStatFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(slowSqlMillis);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }

}
