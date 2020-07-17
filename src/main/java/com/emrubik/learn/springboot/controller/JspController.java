/*******************************************************************************
 * @(#)JspController.java 2020/7/10
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/10 13:13
 */
@Controller
public class JspController {
    @RequestMapping("/jspindex")
    public String index() {
        return "myjsp";
    }
}
