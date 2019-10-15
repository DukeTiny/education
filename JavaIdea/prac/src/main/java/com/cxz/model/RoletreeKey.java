package com.cxz.model;

import java.io.Serializable;

public class RoletreeKey implements Serializable {
    private Integer rid;

    private Integer id;

    private static final long serialVersionUID = 1L;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RoletreeKey{" +
                "rid=" + rid +
                ", id=" + id +
                '}';
    }
}