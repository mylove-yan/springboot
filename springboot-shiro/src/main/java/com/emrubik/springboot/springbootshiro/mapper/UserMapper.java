/*******************************************************************************
 * @(#)UserMapper.java 2020/7/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emrubik.springboot.springbootshiro.bean.User;
import org.springframework.stereotype.Component;

;

/**
 * 用户Mapper
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/28 19:36
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
