/*******************************************************************************
 * @(#)CustomGenericException.java 2020/7/10
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.learn.springboot.exception;

/**
 * 这里请补充该类型的简述说明
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/10 13:17
 */
public class CustomGenericException extends RuntimeException {

    private static final long serialVersionUID = 542673311652976823L;
    private String errorCode;
    private String errorMsg;

    public CustomGenericException(String errCode, String errMsg) {
        this.errorCode = errCode;
        this.errorMsg = errMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
