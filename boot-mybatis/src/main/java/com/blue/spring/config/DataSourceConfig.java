package com.blue.spring.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.jolbox.bonecp.BoneCPDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@PropertySource(value = {"classpath:db/db.properties", "classpath:db/db_druid.properties"})
@Configuration
public class DataSourceConfig{
    private final long slowSqlMillis = 1000;
    private final Logger logger = Logger.getLogger(toString());

    @Resource
    private Environment env;

    @Bean(name = "comboPooledDataSource")
    public ComboPooledDataSource getComboPooledDataSource(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
            comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
            comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
            comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
            comboPooledDataSource.setMinPoolSize(Integer.parseInt(env.getProperty("jdbc.minPoolSize")));
            comboPooledDataSource.setInitialPoolSize(Integer.parseInt(env.getProperty("jdbc.initialPoolSize")));
            comboPooledDataSource.setMaxPoolSize(Integer.parseInt(env.getProperty("jdbc.maxPoolSize")));
            comboPooledDataSource.setMaxIdleTime(Integer.parseInt(env.getProperty("jdbc.maxIdleTime")));
        }catch (Exception e){
            logger.info(";"+e.getMessage());
            e.printStackTrace();
        }
        return comboPooledDataSource;
    }


    @Bean(name = "druidDataSource")
    public DruidDataSource getDruidDataSourceLinux(){
        DruidDataSource dataSource = new DruidDataSource();
        List<Filter> filters = new ArrayList<Filter>();
        filters.add(getStatFilter());
        dataSource.setUsername(env.getProperty("druid.user"));
        dataSource.setPassword(env.getProperty("druid.password"));
        dataSource.setUrl(env.getProperty("druid.url"));
        dataSource.setDriverClassName(env.getProperty("druid.driverClassName"));
        dataSource.setMaxActive(Integer.parseInt(env.getProperty("druid.maxActive")));
        dataSource.setInitialSize(Integer.parseInt(env.getProperty("druid.initialSize")));
        dataSource.setMinIdle(Integer.parseInt(env.getProperty("druid.minIdle")));
        dataSource.setMaxWait(Integer.parseInt(env.getProperty("druid.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(env.getProperty("druid.timeBetweenEvictionRunsMillis")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(env.getProperty("druid.maxPoolPreparedStatementPerConnectionSize")));
        dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(env.getProperty("druid.minEvictableIdleTimeMillis")));
        dataSource.setProxyFilters(filters);
        return dataSource;
    }

    @Bean(name = "boneCPDataSource")
    public DataSource dataSource() {
        BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
        // 数据库驱动
        boneCPDataSource.setDriverClass(env.getProperty("jdbc.driver"));
        // 相应驱动的jdbcUrl
        boneCPDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        // 数据库的用户名
        boneCPDataSource.setUsername(env.getProperty("jdbc.user"));
        // 数据库的密码
        boneCPDataSource.setPassword(env.getProperty("jdbc.password"));
        // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
        boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
        // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
        boneCPDataSource.setIdleMaxAgeInMinutes(30);
        // 每个分区最大的连接数
        boneCPDataSource.setMaxConnectionsPerPartition(100);
        // 每个分区最小的连接数
        boneCPDataSource.setMinConnectionsPerPartition(5);
        return boneCPDataSource;
    }



    private StatFilter getStatFilter(){
        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(slowSqlMillis);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }

}
