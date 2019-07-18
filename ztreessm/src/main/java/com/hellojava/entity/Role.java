package com.hellojava.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role implements Serializable {
    private int roleId;
    private String roleName;
    private List<Promission> promissionList=new ArrayList<>();

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Promission> getPromissionList() {
        return promissionList;
    }

    public void setPromissionList(List<Promission> promissionList) {
        this.promissionList = promissionList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", promissionList=" + promissionList +
                '}';
    }
}
