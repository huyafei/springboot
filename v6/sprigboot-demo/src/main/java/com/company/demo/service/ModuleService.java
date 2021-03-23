package com.company.demo.service;

import com.company.demo.entity.Module;
import com.company.demo.mapper.ModuleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/27 13:51
 */
@Service
public class ModuleService {
    @Resource
    private ModuleMapper moduleMapper;

    public void insertModule(Module module) {
        moduleMapper.insertModule(module);
    }

    public void deleteModule(Integer id) {
        moduleMapper.deleteModule(id);
    }

    public void updateModule(Module module) {
        moduleMapper.updateModule(module);
    }

    public Module selectModuleById(Integer id) {
        return moduleMapper.selectModuleById(id);
    }

    public List<Module> selectModuleAll(Module module) {
        return moduleMapper.selectModuleAll(module);
    }
}
