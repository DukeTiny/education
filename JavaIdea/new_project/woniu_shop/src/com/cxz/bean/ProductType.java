package com.cxz.bean;

public class ProductType {

    private Integer typeID;
    private String typeName;

    public ProductType() {}

    public ProductType(Integer typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
