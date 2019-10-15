package com.cxz.po;

import java.util.Date;

public class Order {

    private Integer id;
    private Integer userLoginId;
    private String orderNum;
    private String tradeNum;
    private Integer deliveryAddressID;
    private Integer state;
    private Date updateTime;
    private Date createTime;
    private Integer status;

    public Order() {}

    public Order(Integer id, Integer userLoginId, String orderNum, String tradeNum, Integer deliveryAddressID, Integer state, Date updateTime, Date createTime, Integer status) {
        this.id = id;
        this.userLoginId = userLoginId;
        this.orderNum = orderNum;
        this.tradeNum = tradeNum;
        this.deliveryAddressID = deliveryAddressID;
        this.state = state;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.status = status;
    }

    public void setId (Integer integer) {
        this.id = integer;
    }

    public Integer getId(){
        return this.id;
    }


    public void setUserLoginId (Integer integer) {
        this.userLoginId = integer;
    }

    public Integer getUserLoginId(){
        return this.userLoginId;
    }


    public void setOrderNum (String string) {
        this.orderNum = string;
    }

    public String getOrderNum(){
        return this.orderNum;
    }


    public void setTradeNum (String string) {
        this.tradeNum = string;
    }

    public String getTradeNum(){
        return this.tradeNum;
    }


    public void setDeliveryAddressID (Integer integer) {
        this.deliveryAddressID = integer;
    }

    public Integer getDeliveryAddressID(){
        return this.deliveryAddressID;
    }


    public void setState (Integer integer) {
        this.state = integer;
    }

    public Integer getState(){
        return this.state;
    }


    public void setUpdateTime (Date date) {
        this.updateTime = date;
    }

    public Date getUpdateTime(){
        return this.updateTime;
    }

    public void setCreateTime (Date date) { 
        this.createTime = date;
    }

    public Date getCreateTime(){
        return this.createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}