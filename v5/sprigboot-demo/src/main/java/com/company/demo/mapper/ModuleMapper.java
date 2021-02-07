package com.company.demo.mapper;

import com.company.demo.entity.Module;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/27 13:21
 */
@Mapper
public interface ModuleMapper {
    void insertModule(Module module);
    void deleteModule(Integer id);
    void updateModule(Module module);
    Module selectModuleById(Integer id);
    List<Module> selectModuleAll(Module module);
    List<Module> selectModuleByRoleId(Integer roleId);
}
