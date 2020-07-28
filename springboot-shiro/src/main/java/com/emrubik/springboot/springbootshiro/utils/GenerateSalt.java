/*******************************************************************************
 * @(#)GenerateSalt.java 2020/7/28
 *
 * Copyright 2020 emrubik Group Ltd. All rights reserved.
 * EMRubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.emrubik.springboot.springbootshiro.utils;

import com.emrubik.springboot.springbootshiro.bean.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * 产生salt
 *
 * @author <a href="mailto:mazh@emrubik.com">Ma Zhihao</a>
 * @version $$Revision 1.5 $$ 2020/7/28 14:50
 */
public class GenerateSalt {

    private final static String algorithmName = "md5";
    private final static String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
    private final static int hashIterations = 2;

    /**
     * 返回密码
     * @param user
     * @return
     */
    public static String generate(User user){
        SimpleHash hash = new SimpleHash(algorithmName, user.getPassword(), user.getUserName()+salt, hashIterations);
        return hash.toHex();
    }

    public static void main(String[] args) {
        User user = new User("liuyan","1234@com");
        System.out.println(GenerateSalt.salt);
        System.out.println(generate(user));
    }


}
