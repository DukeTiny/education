package com.cxz.bean;

import com.cxz.dao.DAOFactory;

import java.util.Date;

public class Stock {

    private Integer purchaseID;
    private Integer productID;
    private Integer quantity;
    private Float primeCost;
    private String purchaseDate;
    private String supplier;
    private String buyer;

    public Stock() {}

    public Stock(Integer purchaseID, Integer productID, Integer quantity, Float primeCost, String purchaseDate, String supplier, String buyer) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.quantity = quantity;
        this.primeCost = primeCost;
        this.purchaseDate = purchaseDate;
        this.supplier = supplier;
        this.buyer = buyer;
    }

    public Integer getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(Integer purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrimeCost() {
        return primeCost;
    }

    public void setPrimeCost(Float primeCost) {
        this.primeCost = primeCost;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
