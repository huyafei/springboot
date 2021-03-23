package com.company.demo.controller;

import com.company.demo.entity.Cost;
import com.company.demo.entity.Result;
import com.company.demo.entity.Role;
import com.company.demo.service.RoleService;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/7 13:12
 */
@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping(value = "/role",method = RequestMethod.POST)
    public Result addRole(@RequestBody Role role){
        System.out.println(role);
        if(role.getName()==null||role.getName().equals("")){
            return ResultUtil.errorParam("请输入名称");
        }
        if(role.getName_en()==null||role.getName_en().equals("")){
            return ResultUtil.errorParam("请输入英文名称");
        }
        roleService.insertRole(role);
        return ResultUtil.success(roleService.selectRoleById(role.getId()));
    }
    @RequestMapping(value = "/role/{id}",method = RequestMethod.DELETE)
    public Result deleteRole(@PathVariable Integer id){
        if (id==null||id.equals("")){
            return ResultUtil.errorParam("参数错误");
        }
        roleService.deleteRole(id);
        return ResultUtil.success();
    }
    @RequestMapping(value = "/role",method = RequestMethod.PUT)
    public Result updateRole(@RequestBody Role role){
        if(role.getId()==null||role.getId().equals("")){
            return ResultUtil.errorParam("参数id错误");
        }
        if(role.getName()==null||role.getName().equals("")){
            return ResultUtil.errorParam("请输入名称");
        }
        if(role.getName_en()==null||role.getName_en().equals("")){
            return ResultUtil.errorParam("请输入英文名称");
        }
        roleService.updateRole(role);
        return ResultUtil.success(roleService.selectRoleById(role.getId()));
    }
    @RequestMapping(value = "/role/{id}",method = RequestMethod.GET)
    public Result selectRoleById(@PathVariable Integer id){
        if(id==null||id.equals("")){
            return ResultUtil.errorParam("参数id错误");
        }
        return ResultUtil.success(roleService.selectRoleById(id));
    }

    /**
     * 获取角色列表（分页 or 分页）
     * @param sort 排序
     * @param page 分页参数
     * @param role 查询条件
     * @return
     */
    @RequestMapping(value = "/role-list",method = RequestMethod.GET)
    public Result selectRoleList(@RequestParam(name="sort",required = false,defaultValue="name asc") String sort, PageRequest page, Role role) {
        PageResult list = roleService.selectRoleList(page,role,sort);
        return ResultUtil.success(list);
    }
}
