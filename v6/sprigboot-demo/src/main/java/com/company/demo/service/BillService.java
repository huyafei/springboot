package com.company.demo.service;

import com.company.demo.entity.Admin;
import com.company.demo.entity.Bill;
import com.company.demo.mapper.BillMapper;
import com.company.demo.utils.PageRequest;
import com.company.demo.utils.PageResult;
import com.company.demo.utils.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.tomcat.jni.BIOCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/18 16:25
 */
@Service
public class BillService {
    @Resource
    private BillMapper billMapper;

    public void insertBill(Bill bill) {
        billMapper.insertBill(bill);
    }

    public void deleteBill(Integer id) {
        billMapper.deleteBill(id);
    }

    public void updateBill(Bill bill) {
        billMapper.updateBill(bill);
    }

    public Bill selectBillById(Integer id) {
        return billMapper.selectBillById(id);
    }

    public PageResult selectBillListPage(PageRequest pageRequest, Bill bill, String sort) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest, bill, sort));
    }

    public PageInfo<Bill> getPageInfo(PageRequest pageRequest, Bill bill, String sort) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize, sort);
        List<Bill> list = billMapper.selectBillListPage(bill);
        return new PageInfo<Bill>(list);
    }
}
