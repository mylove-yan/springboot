/*******************************************************************************
 * @(#)User4Cache.java 2020/7/15
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/15 13:02
 */
@Data
public class User4Cache implements Serializable {

    public User4Cache(Integer id, String userName, Integer age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    private Integer id;
    private String userName;
    private Integer age;
}
