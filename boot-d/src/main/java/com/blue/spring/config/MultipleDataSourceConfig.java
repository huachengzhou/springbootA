package com.blue.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zch
 * @Description
 * @createDate 2018/10/28
 **/
@Configuration
public class MultipleDataSourceConfig {
    private static String dbUrl;

    private static String username;

    private static String password;

    private static String driverClassName;

    private static int initialSize;

    private static int minIdle;

    private static int maxActive;

    private static int maxWait;

    private final static Logger logger = LoggerFactory.getLogger(MultipleDataSourceConfig.class);
    /**
     * 数据源配置对象
     * Primary 表示默认的对象，Autowire可注入，不是默认的得明确名称注入
     *
     * @return
     */
    @Primary//@Primary注解的实例优先于其他实例被注入。
    @Bean(name = "firstDataSourcePropertie")
    @ConfigurationProperties("first.datasource")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    /**
     * 数据源对象
     * @return
     */
    @Primary
    @Bean(name = "firstDataSource")
    @ConfigurationProperties("first.datasource")
    public DataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    /**
     * jdbc
     * @param dataSource
     * @return
     */
    @Primary
    @Bean(name = "firstJdbcTemplate")
    public JdbcTemplate firstJdbcTemplate(@Qualifier("firstDataSource") DataSource dataSource) {
        return new JdbcTemplate(firstDataSource());
    }


    @Bean(name = "secondDataSourcePropertie")
    @ConfigurationProperties("second.datasource")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondDataSource")
    @ConfigurationProperties("second.datasource")
    public DataSource secondDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }


    @Bean(name = "secondJdbcTemplate")
    public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        logger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // IP白名单
        servletRegistrationBean.addInitParameter("allow", "*");
        // IP黑名单(共同存在时，deny优先于allow)
        servletRegistrationBean.addInitParameter("deny", "192.168.1.100");
        //控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        //是否能够重置数据 禁用HTML页面上的“Reset All”功能
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册DruidFilter拦截
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String, String> initParams = new HashMap<String, String>(11);
        //设置忽略请求
        initParams.put("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.setInitParameters(initParams);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**
     * 配置DataSource
     * @return
     * @throws SQLException
     */
    @Bean(name = "druidDataSource")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setUrl(dbUrl);
        druidDataSource.setFilters("stat,wall");
        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setUseGlobalDataSourceStat(true);
        druidDataSource.setDriverClassName(driverClassName);
        return druidDataSource;
    }

    @Value("${spring.datasource.druid.url}")
    public void setDbUrl(String dbUrl) {
        MultipleDataSourceConfig.dbUrl = dbUrl;
    }

    @Value("${spring.datasource.druid.username}")
    public void setUsername(String username) {
        MultipleDataSourceConfig.username = username;
    }

    @Value("${spring.datasource.druid.password}")
    public void setPassword(String password) {
        MultipleDataSourceConfig.password = password;
    }

    @Value("${spring.datasource.driver-class-name}")
    public void setDriverClassName(String driverClassName) {
        MultipleDataSourceConfig.driverClassName = driverClassName;
    }

    @Value(value = "${spring.datasource.druid.initial-size}")
    public void setInitialSize(int initialSize) {
        MultipleDataSourceConfig.initialSize = initialSize;
    }

    @Value(value = "${spring.datasource.druid.min-idle}")
    public void setMinIdle(int minIdle) {
        MultipleDataSourceConfig.minIdle = minIdle;
    }

    @Value(value = "${spring.datasource.druid.max-active}")
    public void setMaxActive(int maxActive) {
        MultipleDataSourceConfig.maxActive = maxActive;
    }

    @Value(value = "${spring.datasource.druid.max-wait}")
    public void setMaxWait(int maxWait) {
        MultipleDataSourceConfig.maxWait = maxWait;
    }

}
