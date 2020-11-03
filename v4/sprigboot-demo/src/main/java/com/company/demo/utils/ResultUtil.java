package com.company.demo.utils;

import com.company.demo.entity.Result;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/22 15:44
 */
public class ResultUtil {
    public static final Integer SUCCESS_CODE = 200; // 成功
    public static final Integer ERROR_CODE = 400; // 错误

    public static Result success() {
        return new Result(SUCCESS_CODE, "操作成功");
    }

    public static Result success(Object object) {
        return new Result(SUCCESS_CODE, "操作成功", object);
    }

    public static Result success(Integer code, String msg, Object object) {
        return new Result(code, msg, object);
    }
    public static Result error() {
        return new Result(ERROR_CODE, "操作失败");
    }
    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }
}
