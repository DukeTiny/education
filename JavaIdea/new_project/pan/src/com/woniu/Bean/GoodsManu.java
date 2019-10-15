package com.woniu.Bean;

public class GoodsManu {
    private Integer GMID;
    private Integer manuID;
    private Integer goodsID;

    public GoodsManu() {}

    public GoodsManu(Integer GMID, Integer manuID, Integer goodsID) {
        this.GMID = GMID;
        this.manuID = manuID;
        this.goodsID = goodsID;
    }

    public Integer getGMID() {
        return this.GMID;
    }

    public void setGMID(Integer GMID) {
        this.GMID = GMID;
    }

    public Integer getManuID() {
        return this.manuID;
    }

    public void setManuID(Integer manuID) {
        this.manuID = manuID;
    }

    public Integer getGoodsID() {
        return this.goodsID;
    }

    public void setGoodsID(Integer goodsID) {
        this.goodsID = goodsID;
    }
}
