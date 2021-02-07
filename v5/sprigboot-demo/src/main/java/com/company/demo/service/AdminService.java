package com.company.demo.service;

import com.company.demo.entity.Admin;
import com.company.demo.mapper.AdminMapper;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/28 13:30
 */
@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;

    public  void addAdmin(Admin admin){
        adminMapper.addAdmin(admin);
    }
    public void delAdmin(Integer id){
        adminMapper.delAdmin(id);
    }
    public void updateAdmin(Admin admin){
        adminMapper.updateAdmin(admin);
    }
    public Admin findById(Integer id){
        return adminMapper.findById(id);
    }
    public List<Admin> findAll(Admin admin){
        System.out.println(adminMapper.findAll(admin));
        return adminMapper.findAll(admin);
    }
    public PageResult selectAdminPage(PageRequest pageRequest, Admin admin, String sort) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,admin,sort));
    }
    private PageInfo<Admin> getPageInfo(PageRequest pageRequest, Admin admin, String sort) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,sort);
        List<Admin> list = adminMapper.selectAdminPage(admin);
        System.out.println(adminMapper.selectAdminPage(admin));
        return new PageInfo<Admin>(list);
    }
}
