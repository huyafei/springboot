package com.company.demo.service;

import com.company.demo.entity.Cost;
import com.company.demo.entity.Role;
import com.company.demo.mapper.RoleMapper;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/27 10:08
 */
/*
* @Service
* */
@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;
    public void insertRole(Role role){
        roleMapper.insertRole(role);
    }
    public void deleteRole(Integer id){
        roleMapper.deleteRole(id);
    }
    public void updateRole(Role role){
        roleMapper.updateRole(role);
    }
    public Role selectRoleById(Integer id){
        return roleMapper.selectRoleById(id);
    }
    /*分页*/
    public PageResult selectRoleList(PageRequest pageRequest, Role role, String sort) {
        return PageUtils.getPageResult(pageRequest, selectRoleListPage(pageRequest,role,sort));
    }
    public PageInfo selectRoleListPage(PageRequest pageRequest, Role role, String sort) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,sort);
        List<Role> list = roleMapper.selectRoleList(role);
        return new PageInfo<Role>(list);
    }

    public List<Role> selectRoleAll(Role role){
        return roleMapper.selectRoleAll(role);
    }
}
