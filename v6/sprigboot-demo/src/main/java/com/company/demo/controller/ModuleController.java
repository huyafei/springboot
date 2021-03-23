package com.company.demo.controller;

import com.company.demo.annotation.UserLoginToken;
import com.company.demo.entity.Module;
import com.company.demo.entity.Result;
import com.company.demo.service.ModuleService;
import com.company.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Map;


/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/1 16:10
 */
/*
 * @RestController注解等价于@ResponseBody ＋ @Controller。
 * @RestController和@Controller的共同点是都用来表示Spring某个类是否可以接收HTTP请求，
 * 区别：
 * @RestController无法返回指定页面，返回数据
 * @Controller可以；前者可以直接返回数据，后者需要@ResponseBody辅助
 * */
@RestController
@RequestMapping("/api")
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

//    @UserLoginToken
    @PostMapping("/module")
    public Result addModule(@RequestBody Module module) {
        if (module.getName() == null || module.getName().equals("")) {
            return ResultUtil.errorParam( "模块名称必填");
        }
        if (module.getUrl() == null || module.getUrl().equals("")) {
            return ResultUtil.errorParam( "模块url必填");
        }
        //名称重复判断
        Module m = new Module();
        m.setName(module.getName());
        List<Module> rm = moduleService.selectModuleAll(m);
        if (rm.size() > 0) {
            return ResultUtil.errorParam("模块名称不能重复");
        }
        moduleService.insertModule(module);
        return ResultUtil.success(moduleService.selectModuleById(module.getId()));
    }
    @DeleteMapping("/module/{id}")
    public Result delModule(@PathVariable Integer id){
        moduleService.deleteModule(id);
        return  ResultUtil.success();
    }
    @PutMapping("/module")
    public Result updateModule(@RequestBody Module module){
        if(module.getId()==null||module.getId().equals("")){
            return ResultUtil.errorParam("id不存在");
        }
        if (module.getName() == null || module.getName().equals("")) {
            return ResultUtil.errorParam("模块名称必填");
        }
        if (module.getUrl() == null || module.getUrl().equals("")) {
            return ResultUtil.errorParam( "模块url必填");
        }
        moduleService.updateModule(module);
        return ResultUtil.success(moduleService.selectModuleById(module.getId()));
    }
    @GetMapping("/module/{id}")
    public Result getModule(@PathVariable("id") int id) {
        Module module = moduleService.selectModuleById(id);
        return ResultUtil.success(module);
    }
}
