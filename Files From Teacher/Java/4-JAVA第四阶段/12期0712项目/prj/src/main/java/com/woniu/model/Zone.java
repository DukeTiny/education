package com.woniu.model;

import java.io.Serializable;

public class Zone implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 1L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zone.zid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    private String zid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zone.zname
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    private String zname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column zone.cid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    private String cid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zone.zid
     *
     * @return the value of zone.zid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public String getZid() {
        return zid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zone.zid
     *
     * @param zid the value for zone.zid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public void setZid(String zid) {
        this.zid = zid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zone.zname
     *
     * @return the value of zone.zname
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public String getZname() {
        return zname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zone.zname
     *
     * @param zname the value for zone.zname
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public void setZname(String zname) {
        this.zname = zname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column zone.cid
     *
     * @return the value of zone.cid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public String getCid() {
        return cid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column zone.cid
     *
     * @param cid the value for zone.cid
     *
     * @mbggenerated Fri Jul 12 12:10:07 CST 2019
     */
    public void setCid(String cid) {
        this.cid = cid;
    }
}