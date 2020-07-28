/*******************************************************************************
 * @(#)PermissionMapper.java 2020/7/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emrubik.springboot.springbootshiro.bean.Permission;
import org.springframework.stereotype.Component;

/**
 * 权限Mapper
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/28 19:43
 */
@Component
public interface PermissionMapper extends BaseMapper<Permission> {
}
