/*******************************************************************************
 * @(#)MyUserMapper.java 2020/7/14
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import com.emrubik.learn.springboot.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/14 7:59
 */
//@Component
public interface MyUserMapper {
    // 查询
    @Select("SELECT * FROM T_USER WHERE NAME = #{name}")
    @Results({
            @Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR)
    })
    User findByName(@Param("name") String name);

    // 删除
    @Delete("DELETE FROM T_USER WHERE id = #{id}")
    int deleteUserById(@Param("id") int id);

    // 添加
    @Insert("INSERT INTO T_USER(NAME,USER_NAME,PASS,AGE,SEX,BIRTHDAY) VALUES (#{name},#{userName}, #{pass}, #{age}, #{sex}, #{birthday})")
    int insertUser(User user);
}
