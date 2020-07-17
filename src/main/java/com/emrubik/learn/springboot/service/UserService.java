/*******************************************************************************
 * @(#)UserService.java 2020/7/13
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.model.User;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/13 8:35
 */
public interface UserService {

    void createUser(User user);

    void deleteUser(User user);

    User getUser(User user);
}
