package com.company.demo.annotation;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/29 14:57
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * token验证step2
 * 用来跳过验证的 PassToken
 * @author MRC
 * @date 2019年4月4日 下午7:01:25
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
