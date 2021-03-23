package com.company.demo.mapper;

import com.company.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/19 15:18
 */
@Mapper
public interface UserMapper {
    void insertUser(User user);
    void deleteUser(Integer id);
    void updateUser(User user);
    User selectUserById(Integer id);
}
