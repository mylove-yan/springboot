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

import java.io.Serializable;
import java.util.Set;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/20 8:51
 */
@Data
@TableName("user_t")
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String password;
    private String salt;


    public User() {
    }

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.password = passWord;
    }

    public User(String userName, String passWord){
        this.userName = userName;
        this.password = passWord;
    }
}
