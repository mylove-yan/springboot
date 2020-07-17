/*******************************************************************************
 * @(#)UserService4MybatisImpl.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 8:01
 */
//@Service
public class UserService4MybatisImpl implements UserService {
    @Autowired
    private MyUserMapper userMapper;

    @Override
    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User getUser(User user) {
        User userRes = userMapper.findByName(user.getName());
        return userRes;
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUserById(user.getId());
    }
}
