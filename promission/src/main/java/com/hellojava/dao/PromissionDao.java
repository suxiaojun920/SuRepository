package com.hellojava.dao;

import com.hellojava.entity.Promission;

import java.util.List;

public interface PromissionDao {
    public List<Promission> loadAll();
    public List<Promission> loadPromissionByRoleId(int rid);
}
