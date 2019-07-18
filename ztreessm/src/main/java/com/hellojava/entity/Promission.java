package com.hellojava.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Promission implements Serializable {
    private int id;
    private int pId;
    private String name;
    private String url;
    private String icon;
    private String checked="true";
    private List<Promission> children=new ArrayList<>();

    public List<Promission> getChildren() {
        return children;
    }

    public void setChildren(List<Promission> children) {
        this.children = children;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
