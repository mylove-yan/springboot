/*******************************************************************************
 * @(#)ShiroSessionListener.java 2020/7/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;

/**
 * session 监听
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/28 13:40
 */
//@Component
//@WebListener
public class ShiroSessionListener extends SessionListenerAdapter {

    Logger logger= LoggerFactory.getLogger(ShiroSessionListener.class);

    @Override
    public void onStart(Session session) {
        logger.info("session创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.info("session停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.info("session过期：" + session.getId());
    }
}
