package com.company.demo.mapper;

import com.company.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/26 16:58
 */
@Mapper
public interface AdminMapper {
    void insertAdmin(Admin admin);
    void deleteAdmin(Integer id);
    void updateAdmin(Admin admin);
    Admin selectAdminById(Integer id);
    List<Admin> selectAdminList(Admin admin);
    List<Admin> selectAdminListPage(Admin admin);
}
