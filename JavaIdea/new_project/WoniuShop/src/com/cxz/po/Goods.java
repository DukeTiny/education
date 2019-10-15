package com.cxz.po;

public class Goods {
    private Integer id;
    private Integer typeId;
    private String goodsName;
    private Double goodsUnitPrice;
    private Integer rest;
    private String goodsPhoto;
    private String description;
    private Integer status;

    public Goods() {}

    public Goods(Integer id, Integer typeId, String goodsName, Double goodsUnitPrice, Integer rest, String goodsPhoto, String description, Integer status) {
        this.id = id;
        this.typeId = typeId;
        this.goodsName = goodsName;
        this.goodsUnitPrice = goodsUnitPrice;
        this.rest = rest;
        this.goodsPhoto = goodsPhoto;
        this.description = description;
        this.status = status;
    }

    public void setId (Integer integer) {
        this.id = integer;
    }

    public Integer getId(){
        return this.id;
    }

    public void setTypeId (Integer integer) {
        this.typeId = integer;
    }

    public Integer getTypeId(){
        return this.typeId;
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


    public void setRest (Integer integer) {
        this.rest = integer;
    }

    public Integer getRest(){
        return this.rest;
    }


    public void setGoodsPhoto (String string) {
        this.goodsPhoto = string;
    }

    public String getGoodsPhoto(){
        return this.goodsPhoto;
    }

    public void setDescription (String string) { 
        this.description = string;
    }

    public String getDescription(){
        return this.description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}