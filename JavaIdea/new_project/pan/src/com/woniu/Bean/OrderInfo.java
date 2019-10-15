package com.woniu.Bean;

import java.util.Date;

public class OrderInfo {

    private Integer orderID;
    private Integer GMID;
    private Integer customerID;
    private Integer routeID;
    private Float shipmentCost;
    private String orderStatus;
    private Date orderDate;

    public OrderInfo() {}

    public OrderInfo(Integer orderID, Integer GMID, Integer customerID, Integer routeID, Float shipmentCost, String orderStatus, Date orderDate) {
        this.orderID = orderID;
        this.GMID = GMID;
        this.customerID = customerID;
        this.routeID = routeID;
        this.shipmentCost = shipmentCost;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getGMID() {
        return GMID;
    }

    public void setGMID(Integer GMID) {
        this.GMID = GMID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getRouteID() {
        return routeID;
    }

    public void setRouteID(Integer routeID) {
        this.routeID = routeID;
    }

    public Float getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(Float shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
