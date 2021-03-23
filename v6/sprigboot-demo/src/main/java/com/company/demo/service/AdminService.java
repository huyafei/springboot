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

    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
    }

    public void deleteAdmin(Integer id) {
        adminMapper.deleteAdmin(id);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    public Admin selectAdminById(Integer id) {
        return adminMapper.selectAdminById(id);
    }

    public List<Admin> selectAdminList(Admin admin) {
        return adminMapper.selectAdminList(admin);
    }

    public PageResult selectAdminListPage(PageRequest pageRequest, Admin admin, String sort) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, admin, sort));
    }

    private PageInfo<Admin> getPageInfo(PageRequest pageRequest, Admin admin, String sort) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize, sort);
        List<Admin> list = adminMapper.selectAdminListPage(admin);
        return new PageInfo<Admin>(list);
    }
}
