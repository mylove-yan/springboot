/*******************************************************************************
 * @(#)UserDao4Cache.java 2020/7/15
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.dao;

import com.emrubik.learn.springboot.model.User4Cache;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/15 13:04
 */
@Repository
public class UserDao4Cache {

    Map<String, User4Cache> data = new HashMap<>();

    public User4Cache getUserById(int id) {
        //模拟数据库返回
        return data.get(id + "");
    }

    public int insertUser(User4Cache user) {
        //模拟数据库返回
        data.put(user.getId() + "", user);
        return 1;
    }

    public User4Cache updateUser(User4Cache user) {
        User4Cache user4Cache = data.get(user.getId() + "");
        if (user4Cache != null) {
            if (user.getAge() != null) {
                user4Cache.setAge(user.getAge());
            }
            if (user.getUserName() != null && !user.getUserName().isEmpty()) {
                user4Cache.setUserName(user.getUserName());
            }
        }
        return user4Cache;
    }
}
