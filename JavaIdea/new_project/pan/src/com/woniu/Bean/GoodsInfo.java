package com.woniu.Bean;

public class GoodsInfo {
    private Integer goodsID;
    private String goodsName;
    private String goodsUnit;
    private Float goodsUnitPrice;
    private Integer goodsWeight;

    public GoodsInfo() {}

    public GoodsInfo(Integer goodsID, String goodsName, String goodsUnit, Float goodsUnitPrice, Integer goodsWeight) {
        this.goodsID = goodsID;
        this.goodsName = goodsName;
        this.goodsUnit = goodsUnit;
        this.goodsUnitPrice = goodsUnitPrice;
        this.goodsWeight = goodsWeight;
    }

    public Integer getGoodsID() {
        return goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public Float getGoodsUnitPrice() {
        return goodsUnitPrice;
    }

    public void setGoodsUnitPrice(Float goodsUnitPrice) {
        this.goodsUnitPrice = goodsUnitPrice;
    }

    public Integer getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(Integer goodsWeight) {
        this.goodsWeight = goodsWeight;
    }
}
