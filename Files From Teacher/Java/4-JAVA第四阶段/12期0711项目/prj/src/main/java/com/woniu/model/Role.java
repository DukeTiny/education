package com.woniu.model;

import java.util.List;

public class Role {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.rid
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
	private List trees;
	
    public List getTrees() {
		return trees;
	}

	public void setTrees(List trees) {
		this.trees = trees;
	}

	private Integer rid;

    @Override
	public String toString() {
		return "" + rname + " ";
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.rname
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    private String rname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.rid
     *
     * @return the value of role.rid
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.rid
     *
     * @param rid the value for role.rid
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.rname
     *
     * @return the value of role.rname
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.rname
     *
     * @param rname the value for role.rname
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    public void setRname(String rname) {
        this.rname = rname;
    }
}