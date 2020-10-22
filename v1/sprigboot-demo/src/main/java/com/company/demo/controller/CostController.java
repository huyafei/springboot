package com.company.demo.controller;

import com.company.demo.entity.Cost;
import com.company.demo.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CostController {
    @Autowired
    private CostService costService;
    @RequestMapping(value ="/cost-list", method = RequestMethod.GET)
    public List<Cost> getCostList() {
        List<Cost> list=costService.getCostList();
        System.out.println(list);
        return list;
    }
}
