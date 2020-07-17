/*******************************************************************************
 * @(#)User.java 2020/7/13
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.model;

import lombok.Data;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/13 8:32
 */
@Data
public class User {
    private int id;
    private String name;
    private String userName;
    private String pass;
    private int age;
    private String sex;
    private String birthday;
}
