package com.woniu.Bean;

import java.util.Date;

public class ShipmentInfo {

    private Integer shipmentID;
    private Integer carID;
    private Integer driverID;
    private Integer orderID;
    private String shipmentStatus;
    private Date shipmentDate;

    public ShipmentInfo() {}

    public ShipmentInfo(Integer shipmentID, Integer carID, Integer driverID, Integer orderID, String shipmentStatus, Date shipmentDate) {
        this.shipmentID = shipmentID;
        this.carID = carID;
        this.driverID = driverID;
        this.orderID = orderID;
        this.shipmentStatus = shipmentStatus;
        this.shipmentDate = shipmentDate;
    }

    public Integer getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(Integer shipmentID) {
        this.shipmentID = shipmentID;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public Integer getDriverID() {
        return driverID;
    }

    public void setDriverID(Integer driverID) {
        this.driverID = driverID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public Date getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Date shipmentDate) {
        this.shipmentDate = shipmentDate;
    }
}
