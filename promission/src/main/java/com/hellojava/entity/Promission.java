package com.hellojava.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Promission implements Serializable {
    private int id;
    private int pId;
    private String name;
    private String url;
    private String icon;
    private String open="false";
    //是否选中
    private String checked="false";
    private List<Promission> children=new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public List<Promission> getChildren() {
        return children;
    }

    public void setChildren(List<Promission> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Promission{" +
                "id=" + id +
                ", pId=" + pId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", open='" + open + '\'' +
                ", checked='" + checked + '\'' +
                ", children=" + children +
                '}';
    }
}
