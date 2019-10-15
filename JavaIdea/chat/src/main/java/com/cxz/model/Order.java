package com.cxz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * order
 * @author 
 */
public class Order implements Serializable {
    /**
     * PRIMARY KEY
     */
    private String orderid;

    /**
     * PRIMARY KEY
     */
    private String storeid;

    /**
     * NOT NULL
     */
    private Date createtime;

    /**
     * ~~~~~~~
     */
    private Date paytime;

    /**
     * ~~~~~~~
     */
    private Date deliverytime;

    /**
     * ~~~~~~~
     */
    private Date recievetime;

    /**
     * FOREIGN KEY
     */
    private String userid;

    /**
     * NOT NULL
     */
    private Integer status;

    /**
     * NOT NULL
     */
    private String deliveryaddr;

    /**
     * ~~~~~~~
     */
    private Date restrecievetime;

    /**
     * NOT NULL
     */
    private String delieverycompany;

    private String deliveryid;

    private Double decreasemoney;

    private Double orderprice;

    private static final long serialVersionUID = 1L;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public Date getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(Date deliverytime) {
        this.deliverytime = deliverytime;
    }

    public Date getRecievetime() {
        return recievetime;
    }

    public void setRecievetime(Date recievetime) {
        this.recievetime = recievetime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDeliveryaddr() {
        return deliveryaddr;
    }

    public void setDeliveryaddr(String deliveryaddr) {
        this.deliveryaddr = deliveryaddr;
    }

    public Date getRestrecievetime() {
        return restrecievetime;
    }

    public void setRestrecievetime(Date restrecievetime) {
        this.restrecievetime = restrecievetime;
    }

    public String getDelieverycompany() {
        return delieverycompany;
    }

    public void setDelieverycompany(String delieverycompany) {
        this.delieverycompany = delieverycompany;
    }

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Double getDecreasemoney() {
        return decreasemoney;
    }

    public void setDecreasemoney(Double decreasemoney) {
        this.decreasemoney = decreasemoney;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Order other = (Order) that;
        return (this.getOrderid() == null ? other.getOrderid() == null : this.getOrderid().equals(other.getOrderid()))
            && (this.getStoreid() == null ? other.getStoreid() == null : this.getStoreid().equals(other.getStoreid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getPaytime() == null ? other.getPaytime() == null : this.getPaytime().equals(other.getPaytime()))
            && (this.getDeliverytime() == null ? other.getDeliverytime() == null : this.getDeliverytime().equals(other.getDeliverytime()))
            && (this.getRecievetime() == null ? other.getRecievetime() == null : this.getRecievetime().equals(other.getRecievetime()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeliveryaddr() == null ? other.getDeliveryaddr() == null : this.getDeliveryaddr().equals(other.getDeliveryaddr()))
            && (this.getRestrecievetime() == null ? other.getRestrecievetime() == null : this.getRestrecievetime().equals(other.getRestrecievetime()))
            && (this.getDelieverycompany() == null ? other.getDelieverycompany() == null : this.getDelieverycompany().equals(other.getDelieverycompany()))
            && (this.getDeliveryid() == null ? other.getDeliveryid() == null : this.getDeliveryid().equals(other.getDeliveryid()))
            && (this.getDecreasemoney() == null ? other.getDecreasemoney() == null : this.getDecreasemoney().equals(other.getDecreasemoney()))
            && (this.getOrderprice() == null ? other.getOrderprice() == null : this.getOrderprice().equals(other.getOrderprice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderid() == null) ? 0 : getOrderid().hashCode());
        result = prime * result + ((getStoreid() == null) ? 0 : getStoreid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getPaytime() == null) ? 0 : getPaytime().hashCode());
        result = prime * result + ((getDeliverytime() == null) ? 0 : getDeliverytime().hashCode());
        result = prime * result + ((getRecievetime() == null) ? 0 : getRecievetime().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeliveryaddr() == null) ? 0 : getDeliveryaddr().hashCode());
        result = prime * result + ((getRestrecievetime() == null) ? 0 : getRestrecievetime().hashCode());
        result = prime * result + ((getDelieverycompany() == null) ? 0 : getDelieverycompany().hashCode());
        result = prime * result + ((getDeliveryid() == null) ? 0 : getDeliveryid().hashCode());
        result = prime * result + ((getDecreasemoney() == null) ? 0 : getDecreasemoney().hashCode());
        result = prime * result + ((getOrderprice() == null) ? 0 : getOrderprice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderid=").append(orderid);
        sb.append(", storeid=").append(storeid);
        sb.append(", createtime=").append(createtime);
        sb.append(", paytime=").append(paytime);
        sb.append(", deliverytime=").append(deliverytime);
        sb.append(", recievetime=").append(recievetime);
        sb.append(", userid=").append(userid);
        sb.append(", status=").append(status);
        sb.append(", deliveryaddr=").append(deliveryaddr);
        sb.append(", restrecievetime=").append(restrecievetime);
        sb.append(", delieverycompany=").append(delieverycompany);
        sb.append(", deliveryid=").append(deliveryid);
        sb.append(", decreasemoney=").append(decreasemoney);
        sb.append(", orderprice=").append(orderprice);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}