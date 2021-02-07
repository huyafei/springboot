package com.company.demo.controller;

import com.company.demo.annotation.PassToken;
import com.company.demo.entity.Admin;
import com.company.demo.entity.Result;
import com.company.demo.service.AdminService;
import com.company.demo.service.LoginService;
import com.company.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/30 13:17
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    private Integer PARAMS_ERROR_CODE = 203;
    @Autowired
    private LoginService loginService;
    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin) {
        System.out.println(admin);
        if (admin.getAdmin_code() == null || admin.getAdmin_code().equals("")) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "请填写账号");
        }
        if (admin.getPassword() == null || admin.getPassword().equals("")) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "请填写密码");
        }
        List<Admin> list = loginService.findAll(admin);

        if (list.size() == 1) {
            Admin userInfo = list.get(0);
            String token = loginService.getToken(userInfo);
            Map<String,String> tokenObj=new HashMap<>();
            tokenObj.put("token",token);
            return ResultUtil.success(tokenObj);
        } else return ResultUtil.error(PARAMS_ERROR_CODE, "账号或密码错误");
    }
}
