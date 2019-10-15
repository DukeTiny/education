package com.woniu.Bean;

import java.util.Date;

public class ManuInfo {
    private Integer manuId;
    private String manuName;
    private String manuAddress;
    private String manuPhone;
    private Date manuDate;

    public ManuInfo() {}

    public ManuInfo(Integer manuId, String manuName, String manuAddress, String manuPhone, Date manuDate) {
        this.manuId = manuId;
        this.manuName = manuName;
        this.manuAddress = manuAddress;
        this.manuPhone = manuPhone;
        this.manuDate = manuDate;
    }

    public Integer getManuId() {
        return manuId;
    }

    public void setManuId(Integer manuId) {
        this.manuId = manuId;
    }

    public String getManuName() {
        return manuName;
    }

    public void setManuName(String manuName) {
        this.manuName = manuName;
    }

    public String getManuAddress() {
        return manuAddress;
    }

    public void setManuAddress(String manuAddress) {
        this.manuAddress = manuAddress;
    }

    public String getManuPhone() {
        return manuPhone;
    }

    public void setManuPhone(String manuPhone) {
        this.manuPhone = manuPhone;
    }

    public Date getManuDate() {
        return manuDate;
    }

    public void setManuDate(Date manuDate) {
        this.manuDate = manuDate;
    }
}
