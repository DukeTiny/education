package com.cxz.po;

import java.util.Date;

public class DeliveryAddress {
    
    private Integer userLoginId;
    private Integer ID;
    private String realName;
    private Integer telephone;
    private String province;
    private String city;
    private String county;
    private String street;
    private String fullAddress;
    private Date updateTime;
    private Date createTime;
    private Integer status;

    public DeliveryAddress() {}

    public DeliveryAddress(Integer userLoginId, Integer ID, String realName, Integer telephone, String province, String city, String county, String street, String fullAddress, Date updateTime, Date createTime, Integer status) {
        this.userLoginId = userLoginId;
        this.ID = ID;
        this.realName = realName;
        this.telephone = telephone;
        this.province = province;
        this.city = city;
        this.county = county;
        this.street = street;
        this.fullAddress = fullAddress;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.status = status;
    }

    public void setUserLoginId (Integer integer) {
        this.userLoginId = integer;
    }

    public Integer getUserLoginId(){
        return this.userLoginId;
    }

    public void setID (Integer integer) {
        this.ID = integer;
    }

    public Integer getID(){
        return this.ID;
    }

    public void setRealName (String string) {
        this.realName = string;
    }

    public String getRealName(){
        return this.realName;
    }

    public void setTelephone (Integer integer) {
        this.telephone = integer;
    }

    public Integer getTelephone(){
        return this.telephone;
    }

    public void setProvince (String string) {
        this.province = string;
    }

    public String getProvince(){
        return this.province;
    }

    public void setCity (String string) {
        this.city = string;
    }

    public String getCity(){
        return this.city;
    }

    public void setCounty (String string) {
        this.county = string;
    }

    public String getCounty(){
        return this.county;
    }

    public void setStreet (String string) {
        this.street = string;
    }

    public String getStreet(){
        return this.street;
    }

    public void setFullAddress (String string) {
        this.fullAddress = string;
    }

    public String getFullAddress(){
        return this.fullAddress;
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

    @Override
    public String toString() {
        return "DeliveryAddress{" +
                "userLoginId=" + userLoginId +
                ", ID=" + ID +
                ", realName='" + realName + '\'' +
                ", telephone=" + telephone +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", street='" + street + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}