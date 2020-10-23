package com.company.demo.errors;

import com.company.demo.entity.Result;
import com.company.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * 注意：ControllerAdvice 注解只拦截 Controller不 会拦截 Interceptor 的异常
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/22 17:05
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody //返回json给客户端
    Result handleException(Exception e){
        return ResultUtil.error();
    }

}
