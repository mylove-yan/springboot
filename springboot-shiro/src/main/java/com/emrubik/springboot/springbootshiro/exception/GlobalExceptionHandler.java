package com.emrubik.springboot.springbootshiro.exception;

import org.apache.shiro.ShiroException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
public class GlobalExceptionHandler {
    //运行时异常进这里,这里返回json
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception exception) {
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", "101");
        map.put("errorMsg", "系統运行时异常! " + exception.getMessage());
        return map;
    }

    //自定义异常进这里,这里返回错误页面
    @ExceptionHandler(ShiroException.class)
    public ModelAndView customGenericExceptionHnadler(ShiroException exception) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message",exception.getMessage());
        return modelAndView;
    }

    //其它异常进这里,可以直接写@ExceptionHandler，IOExeption继承于Exception
    @ExceptionHandler(Exception.class)
    public ModelAndView allExceptionHandler(Exception exception) {
        ModelAndView modelAndView = new ModelAndView("generic_error");
        modelAndView.addObject("errorMsg", "this is all ExceptionHandler!" + exception.getMessage());
        return modelAndView;
    }
}
