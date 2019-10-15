package com.woniu.Bean;

import java.util.Date;

public class DriverInfo {

    private Integer driverID;
    private String driverName;
    private Integer driverYear;
    private String driverPhoto;
    private Integer driverFlag;
    private Date driverDate;

    public DriverInfo() {}

    public DriverInfo(Integer driverID, String driverName, Integer driverYear, String driverPhoto, Integer driverFlag, Date driverDate) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverYear = driverYear;
        this.driverPhoto = driverPhoto;
        this.driverFlag = driverFlag;
        this.driverDate = driverDate;
    }

    public Integer getDriverID() {
        return driverID;
    }

    public void setDriverID(Integer driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Integer getDriverYear() {
        return driverYear;
    }

    public void setDriverYear(Integer driverYear) {
        this.driverYear = driverYear;
    }

    public String getDriverPhoto() {
        return driverPhoto;
    }

    public void setDriverPhoto(String driverPhoto) {
        this.driverPhoto = driverPhoto;
    }

    public Integer getDriverFlag() {
        return driverFlag;
    }

    public void setDriverFlag(Integer driverFlag) {
        this.driverFlag = driverFlag;
    }

    public Date getDriverDate() {
        return driverDate;
    }

    public void setDriverDate(Date driverDate) {
        this.driverDate = driverDate;
    }
}
