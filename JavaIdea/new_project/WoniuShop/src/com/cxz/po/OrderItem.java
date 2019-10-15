package com.cxz.po;

public class OrderItem {

    private Integer OrderID;
    private Integer ID;
    private String goodsName;
    private Double goodsUnitPrice;
    private String goodsPhoto;
    private Integer goodsQuantity;
    private Integer status;

    public OrderItem() {}

    public OrderItem(Integer orderID, Integer ID, String goodsName, Double goodsUnitPrice, String goodsPhoto, Integer goodsQuantity, Integer status) {
        OrderID = orderID;
        this.ID = ID;
        this.goodsName = goodsName;
        this.goodsUnitPrice = goodsUnitPrice;
        this.goodsPhoto = goodsPhoto;
        this.goodsQuantity = goodsQuantity;
        this.status = status;
    }

    public void setOrderID (Integer integer) {
        this.OrderID = integer;
    }

    public Integer getOrderID(){
        return this.OrderID;
    }


    public void setID (Integer integer) {
        this.ID = integer;
    }

    public Integer getID(){
        return this.ID;
    }


    public void setGoodsName (String string) {
        this.goodsName = string;
    }

    public String getGoodsName(){
        return this.goodsName;
    }


    public void setGoodsUnitPrice (Double d) {
        this.goodsUnitPrice = d;
    }

    public Double getGoodsUnitPrice(){
        return this.goodsUnitPrice;
    }

    public void setGoodsPhoto (String string) {
        this.goodsPhoto = string;
    }

    public String getGoodsPhoto(){
        return this.goodsPhoto;
    }

    public void setGoodsQuantity (Integer integer) {
        this.goodsQuantity = integer;
    }

    public Integer getGoodsQuantity(){
        return this.goodsQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}