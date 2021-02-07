package com.company.demo.mapper;

import com.company.demo.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/25 16:33
 */
@Mapper
public interface RoleMapper {
    void insertRole(Role role);
    void deleteRole(Integer id);
    void updateRole(Role role);
    Role selectRoleById(Integer id);
    List<Role> selectRoleList(Role role);

    List<Role> selectRoleAll(Role role);
    Role selectRoleByAdminId(Integer adminId);
}
