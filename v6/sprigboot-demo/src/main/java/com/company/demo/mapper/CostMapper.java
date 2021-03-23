package com.company.demo.mapper;

import com.company.demo.entity.Cost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/9/28 16:45
 */
@Mapper
public interface CostMapper {
    void insertCost(Cost cost);
    void deleteCost(Integer id);
    void updateCost(Cost cost);
    Cost selectCostById(Integer id);
    List<Cost> selectCostList();
    /**
     * 分页查询用户
     * @return
     */
    List<Cost> selectCostListPage(Cost cost);
}
