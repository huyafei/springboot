package com.company.demo.service;

import com.company.demo.mapper.CostMapper;
import com.company.demo.entity.Cost;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public void addCost(Cost cost) {
        costMapper.addCost(cost);
    }

    public void delCost(Integer id) {
        costMapper.delCost(id);
    }

    public void updateCost(Cost cost) {
        costMapper.updateCost(cost);
    }

    public Cost findCostById(Integer id) {
        Cost cost = costMapper.findCostById(id);
        return cost;
    }

    public List<Cost> findAll() {
        List<Cost> list = costMapper.findAll();
        return list;

    }
}
