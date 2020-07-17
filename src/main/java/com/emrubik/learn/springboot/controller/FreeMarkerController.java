/*******************************************************************************
 * @(#)FreeMarkerController.java 2020/7/10
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 *
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/10 12:33
 */
@Controller
public class FreeMarkerController {

    @RequestMapping("/index")
    public String myIndex(Map<String, Object> map) {
        map.put("name", "大鸟哥");
        map.put("age", 22);
        return "myIndex";
    }
}
