package com.company.demo.entity;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/7 15:30
 */
public class Bill {
    private Integer id;
    private Integer userId;
    private String billMonth;
    private double cost;
    private Integer paymentMode;
    private Integer payState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", userId=" + userId +
                ", billMonth='" + billMonth + '\'' +
                ", cost=" + cost +
                ", paymentMode=" + paymentMode +
                ", payState=" + payState +
                '}';
    }
}
