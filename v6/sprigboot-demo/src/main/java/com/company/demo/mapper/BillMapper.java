package com.company.demo.mapper;

import com.company.demo.entity.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/2/18 14:21
 */
@Mapper
public interface BillMapper {
    void insertBill(Bill bill);
    void deleteBill(Integer id);
    void updateBill(Bill bill);
    Bill selectBillById(Integer id);
    List<Bill> selectBillListPage(Bill bill);
}
