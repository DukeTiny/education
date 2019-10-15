package com.cxz.po;

public class Type {

    private Integer id;
    private String type;
    private String photo;
    private String description;
    private Integer prevCode;
    private Integer status;

    public Type() {}

    public Type(Integer id, String type, String photo, String description, Integer prevCode, Integer status) {
        this.id = id;
        this.type = type;
        this.photo = photo;
        this.description = description;
        this.prevCode = prevCode;
        this.status = status;
    }

    public void setId (Integer integer) {
        this.id = integer;
    }

    public Integer getId(){
        return this.id;
    }

    public void setType (String string) {
        this.type = string;
    }

    public String getType(){
        return this.type;
    }

    public void setPhoto (String string) {
        this.photo = string;
    }

    public String getPhoto(){
        return this.photo;
    }

    public void setDescription (String string) {
        this.description = string;
    }

    public String getDescription(){
        return this.description;
    }

    public void setPrevCode (Integer integer) { 
        this.prevCode = integer;
    }

    public Integer getPrevCode(){
        return this.prevCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}