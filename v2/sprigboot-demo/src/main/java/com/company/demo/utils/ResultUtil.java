package com.company.demo.utils;

import com.company.demo.entity.Result;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/22 15:44
 */
public class ResultUtil {
    public static final Integer CODE_SUCCESS = 200; // 成功
    public static final Integer CODE_ERROR = 400; // 错误

    public static Result success() {
        return new Result(CODE_SUCCESS, "操作成功");
    }

    public static Result success(Object object) {
        return new Result(CODE_SUCCESS, "操作成功", object);
    }

    public static Result success(Integer code, String msg, Object object) {
        return new Result(code, msg, object);
    }
    public static Result error() {
        return new Result(CODE_ERROR, "操作失败");
    }
    public static Result error(Integer code, String msg) {
        return new Result(code, msg);
    }
}
