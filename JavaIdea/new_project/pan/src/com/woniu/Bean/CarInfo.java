package com.woniu.Bean;

import java.util.Date;

public class CarInfo {

    private Integer carID;
    private String carBrand;
    private String carEnginenID;
    private String carStatus;
    private Integer carAge;
    private Date carDate;
    private Integer carFlag;

    public CarInfo() {}

    public CarInfo(Integer carID, String carBrand, String carEnginenID, String carStatus, Integer carAge, Date carDate, Integer carFlag) {
        this.carID = carID;
        this.carBrand = carBrand;
        this.carEnginenID = carEnginenID;
        this.carStatus = carStatus;
        this.carAge = carAge;
        this.carDate = carDate;
        this.carFlag = carFlag;
    }

    public Integer getCarID() {
        return carID;
    }

    public void setCarID(Integer carID) {
        this.carID = carID;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarEnginenID() {
        return carEnginenID;
    }

    public void setCarEnginenID(String carEnginenID) {
        this.carEnginenID = carEnginenID;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public Integer getCarAge() {
        return carAge;
    }

    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    public Date getCarDate() {
        return carDate;
    }

    public void setCarDate(Date carDate) {
        this.carDate = carDate;
    }

    public Integer getCarFlag() {
        return carFlag;
    }

    public void setCarFlag(Integer carFlag) {
        this.carFlag = carFlag;
    }
}
