package com.company.demo.controller;

import com.company.demo.annotation.UserLoginToken;
import com.company.demo.entity.Admin;
import com.company.demo.entity.Result;
import com.company.demo.service.AdminService;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.ResultUtil;
import org.apache.tomcat.util.json.JSONParser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/28 13:38
 */
@RestController
@RequestMapping("/api")
public class AdminController {
    private Integer PARAMS_ERROR_CODE = 203;
    @Autowired
    private AdminService adminService;

    /**
     * @param admin
     * @return
     */
    @UserLoginToken
    @PostMapping("/admin-add")
    public Result addAdmin(@RequestBody Admin admin) {
        admin.setCreate_time(new Date());
        if (admin.getAdmin_code() == null || admin.getAdmin_code().equals("")) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "填写账号");
        } else {
            Admin formData = new Admin();
            formData.setAdmin_code(admin.getAdmin_code());
            List<Admin> haveData = adminService.findAll(formData);
            if (haveData.size() > 0) {
                return ResultUtil.error(PARAMS_ERROR_CODE, "账号已存在");
            }
        }
        if (admin.getName() == null | admin.getName().equals("")) {
            admin.setName(admin.getAdmin_code());
        }
        if (admin.getPassword() == null || admin.getPassword().equals("")) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "填写密码");

        }
        adminService.addAdmin(admin);
        return ResultUtil.success(adminService.findById(admin.getId()));

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @UserLoginToken
    @DeleteMapping("/admin-del/{id}")
    public Result delAdmin(@PathVariable("id") Integer id) {
        adminService.delAdmin(id);
        return ResultUtil.success();
    }

    /**
     * 批量删除管理员信息
     *
     * @param ids id逗号隔开
     * @return
     */
    @UserLoginToken
    @DeleteMapping(path = "/admin-del-batch/{ids}")
    public Result delAdminBatch(@PathVariable String ids) {
        String[] idsArr = ids.split(",");
        for (String item : idsArr) {
            adminService.delAdmin(Integer.parseInt(item));
        }
        return ResultUtil.success();
    }

    /**
     * 修改
     *
     * @param admin
     * @return
     */
    @UserLoginToken
    @PutMapping("/admin-put")
    public Result updateAdmin(@RequestBody Admin admin) {
        if (admin.getId() == null) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "传入修改的id值");
        }
        if (admin.getPassword() == null || admin.getPassword().equals("")) {
            return ResultUtil.error(PARAMS_ERROR_CODE, "修改的密码不能为空");
        }
        adminService.updateAdmin(admin);
        return ResultUtil.success(adminService.findById(admin.getId()));
    }
    @GetMapping(value = "/admin/{id}")
    public Result findById(@PathVariable Integer id) {
        Admin admin = adminService.findById(id);
        return ResultUtil.success(admin);
    }

    @RequestMapping(value = "/admin-list", method = RequestMethod.GET)
    public Result findAll(@RequestParam(required = false) Admin admin) {
        List<Admin> list = adminService.findAll(admin);
        return ResultUtil.success(list);
    }

    /**
     * 分页查询管理员列表 分页参数不传查所有
     *
     * @param sort
     * @param admin
     * @param page
     * @return
     */
    @RequestMapping(value = "/admin-list-page", method = RequestMethod.GET)
    public Result selectAdminPage(@RequestParam(name = "sort", required = false, defaultValue = "create_time asc") String sort, Admin admin, PageRequest page) {
        PageResult list = adminService.selectAdminPage(page, admin, sort);
        return ResultUtil.success(list);
    }
}
