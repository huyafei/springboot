package com.company.demo.mapper;

import com.company.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/26 16:58
 */
@Mapper
public interface AdminMapper {
    void addAdmin(Admin admin);
    void delAdmin(Integer id);
    void updateAdmin(Admin admin);
    Admin findById(Integer id);
    List<Admin> findAll(Admin admin);

    List<Admin> selectAdminPage(Admin admin);
}
