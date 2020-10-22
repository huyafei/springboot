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
    List<Cost> findAll();
}
