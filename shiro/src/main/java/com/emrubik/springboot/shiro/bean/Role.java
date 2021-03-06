/*******************************************************************************
 * @(#)Role.java 2020/7/20
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.shiro.bean;

import lombok.Data;

import java.security.Permissions;
import java.util.Set;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/20 8:52
 */
@Data
public class Role {
    private String id;
    private String roleName;
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(String id, String roleName, Set<Permission> permissions) {
        this.id = id;
        this.roleName = roleName;
        this.permissions = permissions;
    }
}
