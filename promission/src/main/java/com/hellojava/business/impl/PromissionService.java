package com.hellojava.business.impl;

import com.hellojava.business.IPromissionService;
import com.hellojava.dao.PromissionDao;
import com.hellojava.entity.Promission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("promissionService")
public class PromissionService implements IPromissionService {
    @Autowired
    public PromissionDao promissionDao;

    @Override
    public List<Promission> loadAll() {
        return promissionDao.loadAll();
    }

    @Override
    public List<Promission> loadPromissionByRoleId(int rid) {
        return promissionDao.loadPromissionByRoleId(rid);
    }

    @Override
    public List<Promission> loadPromissionByRoleIdJson(int rid) {
		//获得指定roleId的全部权限
        List<Promission> list=promissionDao.loadPromissionByRoleId(rid);
        Promission root = new Promission();
        Promission node = new Promission();
		// 拼凑好的json格式的数据
        List<Promission> treelist = new ArrayList<Promission>();
		// parentnodes存放所有的父节点
        List<Promission> parentnodes = new ArrayList<Promission>();

        if (list != null && list.size() > 0) {
            root = list.get(0) ;
            //循环遍历oracle树查询的所有节点
            for (int i = 1; i < list.size(); i++) {
                node = list.get(i);
                if(node.getpId()==root.getId()){
                    //为tree root 增加子节点
                    parentnodes.add(node) ;
                    root.getChildren().add(node) ;
                }else{//获取root子节点的孩子节点
                    getChildrenNodes(parentnodes, node);
                    parentnodes.add(node) ;
                }
            }
        }
        treelist.add(root) ;
        return treelist ;
    }
    private void getChildrenNodes(List<Promission> parentnodes, Promission node) {
        //循环遍历所有父节点和node进行匹配，确定父子关系
        for (int i = parentnodes.size() - 1; i >= 0; i--) {

            Promission pnode = parentnodes.get(i);
            //如果是父子关系，为父节点增加子节点，退出for循环
            if (pnode.getId()==node.getpId()) {
                pnode.getChildren().add(node) ;
                return ;
            } else {
                //如果不是父子关系，删除父节点栈里当前的节点，
                //继续此次循环，直到确定父子关系或不存在退出for循环
                parentnodes.remove(i) ;
            }
        }
    }
}
