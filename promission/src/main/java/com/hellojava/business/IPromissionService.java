package com.hellojava.business;

import com.hellojava.entity.Promission;

import java.util.List;

public interface IPromissionService {
    public List<Promission> loadAll();
    public List<Promission> loadPromissionByRoleId(int rid);
    public List<Promission> loadPromissionByRoleIdJson(int rid);
}
