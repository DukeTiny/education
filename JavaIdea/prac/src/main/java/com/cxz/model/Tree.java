package com.cxz.model;

import java.io.Serializable;

public class Tree implements Serializable {
    private Integer id;

    private Integer pid;

    private String name;

    private String file;

    private String icon;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", file='" + file + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}