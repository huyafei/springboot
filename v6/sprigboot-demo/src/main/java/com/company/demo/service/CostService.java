package com.company.demo.service;

import com.company.demo.mapper.CostMapper;
import com.company.demo.entity.Cost;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    public void insertCost(Cost cost) {
        costMapper.insertCost(cost);
    }

    public void deleteCost(Integer id) {
        costMapper.deleteCost(id);
    }

    public void updateCost(Cost cost) {
        costMapper.updateCost(cost);
    }

    public Cost selectCostById(Integer id) {
        Cost cost = costMapper.selectCostById(id);
        return cost;
    }

    public List<Cost> selectCostList() {
        List<Cost> list = costMapper.selectCostList();
        return list;
    }
    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    public PageResult selectCostListPage(PageRequest pageRequest,Cost cost,String sort) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest,cost,sort));
    }

    /**
     *  调用分页插件完成分页
     *
     * @param pageRequest
     * @param cost
     * @param sort
     * @return
     */
    private PageInfo<Cost> getPageInfo(PageRequest pageRequest,Cost cost,String sort) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize,sort);
        List<Cost> list = costMapper.selectCostListPage(cost);
        return new PageInfo<Cost>(list);
    }
}
