/*******************************************************************************
 * @(#)UserServiceTest.java 2020/7/13
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
 * @version $$Revision 1.5 $$ 2020/7/13 8:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    public void createUser() {
        User user = new User();
        user.setName("陈太太");
        user.setUserName("哈先森");
        user.setAge(22);
        user.setSex("女");
        user.setPass("12334");
        user.setBirthday(LocalDate.now().toString());
        userService.createUser(user);
    }

    @Test
    public void getUser() {
        User user = new User();
        user.setId(1);
        System.out.println(userService.getUser(user));
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1);
        userService.deleteUser(user);
    }
}
