/*******************************************************************************
 * @(#)UserService01.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.mapper.mapper1.UserMapper01;
import com.emrubik.learn.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 13:30
 */
@Service
public class UserService01 {
    @Autowired
    private UserMapper01 userMapper01;

    public int insertUser(String name, String userName, int age) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setAge(age);
        int insertUserResult = userMapper01.insertUser(user);
        return insertUserResult;
    }

    public User queryUserByName(String userName) {
        User user = userMapper01.findUserByUserName(userName);
        return user;
    }

    public List<User> queryAllUsers() {
        List<User> allUsers = userMapper01.findAllUsers();
        return allUsers;
    }
}

