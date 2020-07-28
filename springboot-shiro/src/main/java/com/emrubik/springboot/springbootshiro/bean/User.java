/*******************************************************************************
 * @(#)User.java 2020/7/20
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Set;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/20 8:51
 */
@Data
@TableName("user_t")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String userName;
    private String password;
    private String salt;
    private Set<Role> roles;


    public User() {
    }

    public User(String id, String userName, String password, Set<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
