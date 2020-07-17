/*******************************************************************************
 * @(#)UserService02.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.mapper.mapper1.UserMapper01;
import com.emrubik.learn.springboot.mapper.mapper2.UserMapper02;
import com.emrubik.learn.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 13:32
 */
@Service
public class UserService02 {
    @Autowired
    private UserMapper01 userMapper01;
    @Autowired
    private UserMapper02 userMapper02;

    public int insertUser(String name, String userName, Integer age) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setAge(age);
        int insertUserResult = userMapper02.insertUser(user);
        return insertUserResult;
    }

    public int insertUserTest01AndTest02(String name, String userName, Integer age) {
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setAge(age);
        // 第一个数据源
        int insertUserResult01 = userMapper01.insertUser(user);
        // 第二个数据源
        int insertUserResult02 = userMapper02.insertUser(user);
        int result = insertUserResult01 + insertUserResult02;
        return result;
    }

    public List<User> queryAllUsers() {
        List<User> allUsers1 = userMapper01.findAllUsers();
        List<User> allUsers2 = userMapper02.findAllUsers();
        allUsers2.addAll(allUsers1);
        return allUsers2;
    }
}
