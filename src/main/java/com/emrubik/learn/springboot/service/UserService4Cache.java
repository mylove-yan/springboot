/*******************************************************************************
 * @(#)UserService4Cache.java 2020/7/15
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.dao.UserDao4Cache;
import com.emrubik.learn.springboot.model.User4Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/15 13:04
 */
@Service
public class UserService4Cache {

    @Autowired
    UserDao4Cache userDao;

    @CacheEvict(value = "userCache", key = "#user.id")
    public int saveUser(User4Cache user) {
        return userDao.insertUser(user);
    }

    @Cacheable(value = "userCache", key = "#userId")
    public User4Cache getUser(int userId) {
        return userDao.getUserById(userId);
    }

    @CachePut(value = "userCache", key = "#user.id")
    public User4Cache updateUser(User4Cache user) {
        return userDao.updateUser(user);
    }
}
