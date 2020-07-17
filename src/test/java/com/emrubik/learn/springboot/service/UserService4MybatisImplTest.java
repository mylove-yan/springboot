/*******************************************************************************
 * @(#)UserService4MybatisImplTest.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 8:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserService4MybatisImplTest {
    @Autowired
    MyUserMapper userMapper;

    @Test
    public void createUser() {
        User user = new User();
        user.setName("周老板");
        user.setUserName("周先森");
        user.setAge(22);
        user.setSex("男");
        user.setPass("212334");
        user.setBirthday(LocalDate.now().toString());
        userMapper.insertUser(user);
    }

    @Test
    public void getUser() {
        User user = userMapper.findByName("周老板");
        System.out.println(user);
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUserById(2);
    }
}
