/*******************************************************************************
 * @(#)Permission.java 2020/7/20
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/20 8:53
 */
@Data
public class Permission  implements Serializable {
    private Integer id;
    private String permissionsName;

    public Permission() {
    }

    public Permission(Integer id, String permissionsName) {
        this.id = id;
        this.permissionsName = permissionsName;
    }
}
