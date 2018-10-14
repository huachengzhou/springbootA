# 全局配置文件

> Spring Boot项目使用一个全局的配置文件application.properties或者是application.yml，在resources目录下或者类路径下的/config下，一般我们放到resources下

+ 1 tomcat端口
```
server.port=8088
```

+ 2

## Spring Boot的自动配置的原理
```
Spring Boot在进行SpringApplication对象实例化时会加载META-INF/spring.factories文件，将该配置文件中的配置载入到Spring容器
```

+ application.yml
```
server:  
  port: 8090  
  session-timeout: 30  
  tomcat.max-threads: 0  
  tomcat.uri-encoding: UTF-8  
  
spring:  
  datasource:  
    url : jdbc:mysql://localhost:3306/newbirds  
    username : root  
    password : mymysql  
    driverClassName : com.mysql.jdbc.Driver  
```
> 1，原有的key，例如spring.jpa.properties.hibernate.dialect，按“.”分割，都变成树状的配置
  2，key后面的冒号，后面一定要跟一个空格
  3，把原有的application.properties删掉。然后一定要执行一下  maven -X clean install