package com.company.demo.service;

import com.company.demo.mapper.CostMapper;
import com.company.demo.entity.Cost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/10/20 14:58
 */
@Service
public class CostService {
    //@AutoWried按by type自动注入，而@Resource默认按byName自动注入
    @Resource
    private CostMapper costMapper;
    public List<Cost> getCostList() {
        List<Cost> list = costMapper.findAll();
        return list;

    }
}
