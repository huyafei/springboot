package com.company.demo.controller;

import com.company.demo.annotation.UserLoginToken;
import com.company.demo.entity.Admin;
import com.company.demo.entity.Result;
import com.company.demo.service.AdminService;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import com.company.demo.utils.StringUtil;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/28 13:38
 */
@RestController
@RequestMapping("/api")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 增
     *
     * @param admin
     * @return
     */
//    @UserLoginToken
    @PostMapping("/admin")
    public Result insertAdmin(@RequestBody Admin admin) {
        if (admin.getAdminCode() == null || admin.getAdminCode().equals("")) {
            return ResultUtil.errorParam("填写账号");
        } else {
            Admin newAdmin = new Admin();
            newAdmin.setAdminCode(admin.getAdminCode());
            List<Admin> adminList = adminService.selectAdminList(newAdmin);
            if (adminList.size() > 0) {
                return ResultUtil.errorParam("账号已存在");
            }
        }
        if (admin.getName() == null || admin.getName().equals("")) {
            admin.setName(admin.getAdminCode());
        }
        if (admin.getPassword() == null || admin.getPassword().equals("")) {
            return ResultUtil.errorParam("填写密码");

        }
        Date date = new Date();
        admin.setCreateTime(date);
        admin.setUpdateTime(date);
        adminService.insertAdmin(admin);
        return ResultUtil.success(adminService.selectAdminById(admin.getId()));

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
//    @UserLoginToken
    @DeleteMapping("/admin/{id}")
    public Result deleteAdmin(@PathVariable("id") Integer id) {
        adminService.deleteAdmin(id);
        return ResultUtil.success();
    }

    /**
     * 批量删除管理员信息
     *
     * @param ids id逗号隔开
     * @return
     */
//    @UserLoginToken
    @DeleteMapping(path = "/admin-del-batch/{ids}")
    public Result deleteAdminBatch(@PathVariable String ids) {
        String[] idsArr = ids.split(",");
        for (String item : idsArr) {
            adminService.deleteAdmin(Integer.parseInt(item));
        }
        return ResultUtil.success();
    }

    /**
     * 修改
     *
     * @param admin
     * @return
     */
//    @UserLoginToken
    @PutMapping("/admin")
    public Result updateAdmin(@RequestBody Admin admin) {
        if (admin.getId() == null || admin.getId().equals("")) {
            return ResultUtil.errorParam("传入修改的id值");
        }
        if (admin.getPassword() == null || admin.getPassword().equals("")) {
            return ResultUtil.errorParam("修改的密码不能为空");
        }
        admin.setUpdateTime(new Date());
        adminService.updateAdmin(admin);
        return ResultUtil.success(adminService.selectAdminById(admin.getId()));
    }

    /**
     * 查（详情）
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/admin/{id}")
    public Result selectAdminById(@PathVariable Integer id) {
        if (id == null || id.equals("")) {
            return ResultUtil.errorParam("参数id错误");
        }
        Admin admin = adminService.selectAdminById(id);
        return ResultUtil.success(admin);
    }

    /**
     * 查所有
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "/admin-list", method = RequestMethod.GET)
    public Result selectAdminList(@RequestParam(required = false) Admin admin) {
        List<Admin> list = adminService.selectAdminList(admin);
        return ResultUtil.success(list);
    }

    /**
     * 分页查询管理员列表 分页参数不传查所有
     * asc 升序 desc 降序
     * @param sort
     * @param admin
     * @param page
     * @return
     */
    @RequestMapping(value = "/admin-list-page", method = RequestMethod.GET)
    public Result selectAdminListPage(@RequestParam(name = "sort", required = false, defaultValue = "createTime asc") String sort, Admin admin, PageRequest page) {
        String[] sortArr = sort.split(" ");
        String fieldName = StringUtil.camel2Underline(sortArr[0], true);
        PageResult list = adminService.selectAdminListPage(page, admin, fieldName + " " + sortArr[1]);
        return ResultUtil.success(list);
    }
}
