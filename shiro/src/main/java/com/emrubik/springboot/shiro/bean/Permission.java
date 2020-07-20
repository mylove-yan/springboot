/*******************************************************************************
 * @(#)Permission.java 2020/7/20
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.shiro.bean;

import lombok.Data;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/20 8:53
 */
@Data
public class Permission {
    private String id;
    private String permissionsName;

    public Permission() {
    }

    public Permission(String id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }
}
