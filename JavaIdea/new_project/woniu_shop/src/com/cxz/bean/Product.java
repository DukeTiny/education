package com.cxz.bean;

public class Product {
    private Integer productID;
    private String productName;
    private String productBrand;
    private Integer typeID;
    private Float unitPrice;
    private String unit;
    private String productPhoto;
    private Integer onSale;
    private String priority;

    public Product() {}


    public Product(Integer productID, String productName, String productBrand, Integer typeID, Float unitPrice, String unit, String productPhoto, Integer onSale, String priority) {
        this.productID = productID;
        this.productName = productName;
        this.productBrand = productBrand;
        this.typeID = typeID;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.productPhoto = productPhoto;
        this.onSale = onSale;
        this.priority = priority;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public Integer getOnSale() {
        return onSale;
    }

    public void setOnSale(Integer onSale) {
        this.onSale = onSale;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
