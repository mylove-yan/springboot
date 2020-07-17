/*******************************************************************************
 * @(#)UserMapper01.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.mapper.mapper1;

import com.emrubik.learn.springboot.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 13:25
 */
@Component
public interface UserMapper01 {
    // 查询
    @Select("SELECT * FROM T_USER WHERE USER_NAME = #{userName}")
    @Results({@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR)})
    User findUserByUserName(@Param("userName") String userName);

    @Select("SELECT * FROM T_USER ")
    @Results({@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR)})
    List<User> findAllUsers();

    // 新增
    @Insert("INSERT INTO T_USER(NAME,USER_NAME,PASS,AGE,SEX,BIRTHDAY) VALUES (#{name},#{userName}, #{pass}, #{age}, #{sex}, #{birthday})")
    int insertUser(User user);
}
