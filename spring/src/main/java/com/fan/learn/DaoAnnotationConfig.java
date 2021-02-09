/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 15:17
 */
package com.fan.learn;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by fanyuexin on 2021/02/09
 */
@Configuration
@ComponentScan(basePackages = "com.fan.learn.dao")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class DaoAnnotationConfig {

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/database1?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(@Autowired DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(getDataSource());
    }


}
