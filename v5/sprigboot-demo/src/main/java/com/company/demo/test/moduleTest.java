package com.company.demo.test;

import com.company.demo.service.CostService;
import com.company.demo.service.ModuleService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/1 15:28
 */
public class moduleTest {
    @Autowired
    private ModuleService moduleService;
    @Test
    public void  selectModuleByIdTest(){
    }
}
