package com.company.demo.controller;

import com.company.demo.entity.Result;
import com.company.demo.entity.User;
import com.company.demo.service.UserService;
import com.company.demo.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/19 17:23
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Resource
    private UserService userService;
    @PostMapping("/user")
    public Result insertUser(@RequestBody User user){
        userService.insertUser(user);
        return ResultUtil.success(userService.selectUserById(user.getId()));
    }
    @DeleteMapping("/user/{id}")
    public Result insertUser(@PathVariable Integer id){
        if (id==null||id.equals("")){
            return ResultUtil.errorParam("参数id无效");
        }
        userService.deleteUser(id);
        return ResultUtil.success();
    }
    @PutMapping("/user")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResultUtil.success(userService.selectUserById(user.getId()));
    }
    @GetMapping("/user/{id}")
    public Result selectUserById(@PathVariable Integer id){
        return ResultUtil.success(userService.selectUserById(id));
    }
}
