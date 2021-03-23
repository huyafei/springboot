package com.company.demo.service;

import com.company.demo.entity.User;
import com.company.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/19 17:19
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public void insertUser(User user){
        userMapper.insertUser(user);
    }
    public void deleteUser(Integer id){
        userMapper.deleteUser(id);
    };
    public void updateUser(User user){
        userMapper.updateUser(user);
    }
    public User selectUserById(Integer id){
        return userMapper.selectUserById(id);
    }
}
