package com.company.demo.entity;

import java.util.List;
import java.util.Objects;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/7 15:29
 */
public class Role {
    private Integer id;
    private String name;
    private String name_en;
    private List<Module> modules;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }
}
