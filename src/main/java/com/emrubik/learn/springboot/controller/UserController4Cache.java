/*******************************************************************************
 * @(#)UserController4Cache.java 2020/7/15
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.controller;

import com.emrubik.learn.springboot.model.User4Cache;
import com.emrubik.learn.springboot.service.UserService4Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/15 13:05
 */
@RestController
@RequestMapping("cache")
public class UserController4Cache {

    @Autowired
    UserService4Cache userService;

    @RequestMapping(value = "/saveUser")
    public int saveUser(User4Cache user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/queryUser")
    public User4Cache queryUser(@RequestParam Integer id) {
        User4Cache user = userService.getUser(id);
        if (user == null) {
            System.out.println("没有查到数据,uid:" + id);
        }
        return user;
    }

    @RequestMapping(value = "/updateUser")
    public User4Cache updateUser(User4Cache user) {
        return userService.updateUser(user);
    }
}
