/*******************************************************************************
 * @(#)RoleMapper.java 2020/7/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emrubik.springboot.springbootshiro.bean.Role;
import com.emrubik.springboot.springbootshiro.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色Mapper
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/28 19:42
 */
@Component
public interface RoleMapper extends BaseMapper<Role> {

    public List<Role> queryByUserId(@Param("userId") Integer userId);

}
