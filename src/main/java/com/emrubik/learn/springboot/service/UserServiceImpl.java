/*******************************************************************************
 * @(#)UserServiceImpl.java 2020/7/13
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/13 8:36
 */
//@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(User user) {
        jdbcTemplate.update("insert into t_user(name,user_name,pass,age,sex,birthday) values(?,?,?,?,?,?);",
                user.getName(), user.getUserName(), user.getPass(), user.getAge(), user.getSex(), user.getBirthday());
    }

    @Override
    public void deleteUser(User user) {
        jdbcTemplate.update("delete from t_user where id=?", user.getId());
    }

    @Override
    public User getUser(User user) {
        return jdbcTemplate.queryForObject("select * from t_user where id=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet res, int i) throws SQLException {
                User userRes = new User();
                userRes.setId(res.getInt("id"));
                userRes.setName(res.getString("name"));
                userRes.setUserName(res.getString("user_name"));
                userRes.setAge(res.getInt("age"));
                userRes.setSex(res.getString("sex"));
                userRes.setPass(res.getString("pass"));
                userRes.setBirthday(res.getDate("birthday").toString());
                return userRes;
            }
        }, user.getId());
    }
}
