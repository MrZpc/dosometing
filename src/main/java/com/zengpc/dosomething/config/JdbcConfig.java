package com.zengpc.dosomething.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration//声明这是一个配置文件类相当于xml
//@PropertySource("classpath:application.properties") //读取资源文件
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {
    //1、通过 Autowired 注入
    @Autowired
    private JdbcProperties jdbcProperties;

    /*//2、通过构造的方式注入
    private JdbcProperties jdbcProperties;
    public JdbcConfig (JdbcProperties jdbcProperties){
        this.jdbcProperties = jdbcProperties;
    }*/

    @Bean
    //3、通过形参
    //public DataSource dataSource(JdbcProperties jdbcProperties){
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(this.jdbcProperties.getDriverClassName());
        druidDataSource.setUrl(this.jdbcProperties.getUrl());
        druidDataSource.setUsername(this.jdbcProperties.getUsername());
        druidDataSource.setPassword(this.jdbcProperties.getPassword());
        return druidDataSource;
    }

/* //4、
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }*/
}
