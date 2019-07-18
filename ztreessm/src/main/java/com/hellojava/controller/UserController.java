package com.hellojava.controller;

import com.hellojava.business.IUserService;
import com.hellojava.entity.Promission;
import com.hellojava.entity.TreeView;
import com.hellojava.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@SessionAttributes(names = {"currentUser"})
public class UserController {
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping("loadUser")
    public int loadUser(User user, Model model){
        User u=userService.loadUser(user);
        model.addAttribute("currentUser",u);
        System.out.println(u);
        return u!=null?1:0;
    }

    @ResponseBody
    @RequestMapping("loadpromission")
    public List<Promission> loadUserPromission(User user,HttpSession session){
        User u=userService.loadUser(user);
        System.out.println(u);
        List<Promission> promissions=u.getRole().getPromissionList();
        System.out.println(promissions);
        return promissions;
    }

    @ResponseBody
    @RequestMapping("loadpromissioneasyui")
    public Promission loadPromission(User user){
        User u=userService.loadUser(user);
        Promission root=u.getRole().getPromissionList().get(0);
        loadTreeNode(root, u.getRole().getPromissionList());
        System.out.println(root);
        return root;
    }

    public void loadTreeNode(Promission root,List<Promission> list){
        for(Promission p : list){
           if(p.getpId()==root.getId()){
               root.getChildren().add(p);
               loadTreeNode(p,list);
           }
        }
    }

    @ResponseBody
    @RequestMapping("loadtreeview")
    public List<TreeView> loadTreeView(){
        List<TreeView> treeList = new ArrayList<TreeView>();

        TreeView treeView = new TreeView();
        treeView.setId(1);
        treeView.setName("祥");
        treeView.setpId(0);
        treeView.setUrl("");
        TreeView treeView1 = new TreeView();
        treeView1.setId(2);
        treeView1.setName("呵呵");
        treeView1.setpId(1);
        treeView1.setUrl("");
        TreeView treeView2 = new TreeView();
        treeView2.setId(3);
        treeView2.setName("哈哈");
        treeView2.setpId(1);
        treeView2.setUrl("");
        TreeView treeView3 = new TreeView();
        treeView3.setId(4);
        treeView3.setName("呵呵");
        treeView3.setpId(1);
        treeView3.setUrl("");

        treeList.add(treeView);
        treeList.add(treeView1);
        treeList.add(treeView2);
        treeList.add(treeView3);

        return treeList;
    }
}
