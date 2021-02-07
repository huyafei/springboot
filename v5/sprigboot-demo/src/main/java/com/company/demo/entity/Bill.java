package com.company.demo.entity;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2021/1/7 15:30
 */
public class Bill {
    private Integer id;
    private Integer user_id;
    private String bill_month;
    private double cost;
    private Integer payment_mode;
    private Integer pay_state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBill_month() {
        return bill_month;
    }

    public void setBill_month(String bill_month) {
        this.bill_month = bill_month;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(Integer payment_mode) {
        this.payment_mode = payment_mode;
    }

    public Integer getPay_state() {
        return pay_state;
    }

    public void setPay_state(Integer pay_state) {
        this.pay_state = pay_state;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", bill_month='" + bill_month + '\'' +
                ", cost=" + cost +
                ", payment_mode=" + payment_mode +
                ", pay_state=" + pay_state +
                '}';
    }
}
