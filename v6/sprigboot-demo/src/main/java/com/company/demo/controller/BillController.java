package com.company.demo.controller;

import com.company.demo.entity.Admin;
import com.company.demo.entity.Bill;
import com.company.demo.entity.Result;
import com.company.demo.service.BillService;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.ResultUtil;
import com.company.demo.utils.StringUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/18 17:18
 */
@RestController
@RequestMapping("/api")
public class BillController {
    @Resource
    private BillService billService;

    /**
     * 增
     * @param bill
     * @return
     */
    @RequestMapping(value = "/bill",method = RequestMethod.POST)
    public Result insertBill(@RequestBody Bill bill){
        billService.insertBill(bill);
        return ResultUtil.success(billService.selectBillById(bill.getId()));
    }

    /**
     * 删
     * @param id
     * @return
     */
    @RequestMapping(value = "/bill/{id}",method = RequestMethod.DELETE)
    public Result deleteBill(@PathVariable Integer id){
        billService.deleteBill(id);
        return  ResultUtil.success();
    }

    /**
     * 改
     * @param bill
     * @return
     */
    @RequestMapping(value = "/bill",method = RequestMethod.PUT)
    public Result updateBill(@RequestBody Bill bill){
        if (bill.getId()==null||bill.getId().equals("")){
            return ResultUtil.errorParam("参数id错误");
        }
        billService.updateBill(bill);
        return ResultUtil.success(billService.selectBillById(bill.getId()));
    }

    /**
     * 查
     * @param id
     * @return
     */
    @RequestMapping(value = "/bill/{id}",method = RequestMethod.GET)
    public Result selectBillById(@PathVariable Integer id){
        return ResultUtil.success(billService.selectBillById(id));
    }
    @RequestMapping(value = "/bill-list-page",method = RequestMethod.GET)
    public Result selectBillListPage(@RequestParam(name = "sort", required = false, defaultValue = "billMonth asc") String sort, Bill bill, PageRequest page){
        System.out.println(bill);
        String[] sortArr = sort.split(" ");
        String fieldName = StringUtil.camel2Underline(sortArr[0], true);
        System.out.println(fieldName + " " + sortArr[1]);
        PageResult list = billService.selectBillListPage(page, bill, fieldName + " " + sortArr[1]);
        System.out.println(list);
        return ResultUtil.success(list);

    }
}
