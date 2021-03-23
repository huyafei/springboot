package com.company.demo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.company.demo.entity.Admin;
import com.company.demo.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/30 13:21
 */
@Service
public class LoginService {
    @Resource
    private AdminMapper adminMapper;
    public List<Admin> findAll(Admin admin){
        return adminMapper.selectAdminList(admin);
    }
    public String getToken(Admin admin) {
        String token = "";
        Date start = new Date();
        long currentTime = System.currentTimeMillis() +1000*60*60*2;//2小时 时间戳 毫秒数
        Date end = new Date(currentTime);
        //标准的声明，类似开发语言总的关键字。包括
        //iss（Issuser） - 签发者
        //sub Subject 面向主体
        //aud Audience 接收方
        //exp Expiration time 过期时间戳
        //nbf Not Before, 开始生效时间戳
        //iat(Issued at) 签发时间
        //jti(JWT ID)： 唯一标识
        token = JWT.create()
                .withAudience(admin.getId().toString()) //设置接受方信息，一般时登录用户
                .withExpiresAt(end) //设置过期时间
                .sign(Algorithm.HMAC256(admin.getPassword())); //使用HMAC算法，密码作为密钥加密
        System.out.println(token);
        return token;
    }
}
