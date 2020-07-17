/*******************************************************************************
 * @(#)Log4j2Service2.java 2020/7/15
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Service;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/15 12:52
 */
@Service
public class Log4j2Service2 {
    private Logger logger = LogManager.getLogger(Log4j2Service2.class);

    public void showLog() {
        logger.debug("Log4j2Service2我是DEBUG日志11");
        logger.info("Log4j2Service2我是INFO日志22");
        logger.warn("Log4j2Service2我是WARN日志33");
        logger.error("Log4j2Service2我是ERROR日志44");
        Marker marker = MarkerManager.getMarker("test");
        logger.error(marker, "Log4j2Service2我是ERROR日志55");
        logger.fatal("Log4j2Service2我是FATAL日志66");
    }
}
