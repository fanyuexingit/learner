/**
 * @description:
 * @author: Andy
 * @time: 2021/02/09 14:29
 */
package com.fan.learn.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by fanyuexin on 2021/02/09
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save() {
        String sql = "insert into user111(name,age) values('fanyeuxin','123')";
        jdbcTemplate.update(sql);
    }

    @Override
    public void query() {
        String sql = "select * from user111";
        List<User> query = jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setAge(resultSet.getInt("age"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
        System.out.println(query);
    }
}
