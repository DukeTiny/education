package com.cxz.l_select_key;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Dept implements Serializable {

    private Integer did;
    private String dName;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", dName='" + dName + '\'' +
                '}';
    }

}
