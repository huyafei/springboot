package com.company.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/26 16:04
 */

public class Admin {
    private Integer id;
    private String admin_code;
    private String password;
    private String name;
    private String telephone;
    private String email;
    private  Date create_time;
    private  String token;

    public Admin() {
    }

    public Admin(Integer id, String admin_code, String password, String name, String telephone, String email, Date create_time, String token) {
        this.id = id;
        this.admin_code = admin_code;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.email = email;
        this.create_time = create_time;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdmin_code() {
        return admin_code;
    }

    public void setAdmin_code(String admin_code) {
        this.admin_code = admin_code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", admin_code='" + admin_code + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", create_time=" + create_time +
                ", token='" + token + '\'' +
                '}';
    }
}
