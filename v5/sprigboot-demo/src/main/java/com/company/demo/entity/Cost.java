package com.company.demo.entity;

import java.sql.Date;
import java.util.Objects;

/**
 * @author yf.hu
 * @version 1.0
 * @date 2020/9/28 16:33
 */
public class Cost {
    private Integer id;
    private String name;
    private Integer base_duration;
    private double base_cost;
    private double unit_cost;
    private Integer status;
    private String descr;
    private Date create_time;
    private Date start_time;
    private Integer cost_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBase_duration() {
        return base_duration;
    }

    public void setBase_duration(Integer base_duration) {
        this.base_duration = base_duration;
    }

    public double getBase_cost() {
        return base_cost;
    }

    public void setBase_cost(double base_cost) {
        this.base_cost = base_cost;
    }

    public double getUnit_cost() {
        return unit_cost;
    }

    public void setUnit_cost(double unit_cost) {
        this.unit_cost = unit_cost;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Integer getCost_type() {
        return cost_type;
    }

    public void setCost_type(Integer cost_type) {
        this.cost_type = cost_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cost cost = (Cost) o;
        return Double.compare(cost.base_cost, base_cost) == 0 &&
                Double.compare(cost.unit_cost, unit_cost) == 0 &&
                Objects.equals(id, cost.id) &&
                Objects.equals(name, cost.name) &&
                Objects.equals(base_duration, cost.base_duration) &&
                Objects.equals(status, cost.status) &&
                Objects.equals(descr, cost.descr) &&
                Objects.equals(create_time, cost.create_time) &&
                Objects.equals(start_time, cost.start_time) &&
                Objects.equals(cost_type, cost.cost_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, base_duration, base_cost, unit_cost, status, descr, create_time, start_time, cost_type);
    }

    @Override
    public String toString() {
        return "Const{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", base_duration=" + base_duration +
                ", base_cost=" + base_cost +
                ", unit_cost=" + unit_cost +
                ", status=" + status +
                ", descr='" + descr + '\'' +
                ", create_time=" + create_time +
                ", start_time=" + start_time +
                ", cost_type=" + cost_type +
                '}';
    }
}
