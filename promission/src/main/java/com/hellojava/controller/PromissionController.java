package com.hellojava.controller;

import com.hellojava.business.IPromissionService;
import com.hellojava.entity.Promission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PromissionController {
    @Autowired
    private IPromissionService promissionService;

    @ResponseBody
    @RequestMapping("loadAllPromission")
    public List<Promission> loadAllPromission(int rid){
        return promissionService.loadPromissionByRoleIdJson(rid);
    }

    @ResponseBody
    @RequestMapping("loadAllPromissionChecked")
    public List<Promission> loadAllPromissionChecked(int rid){
        List<Promission> promissions=promissionService.loadAll();
        List<Promission> rolePromission=promissionService.loadPromissionByRoleId(rid);
        for (Promission p:promissions) {
            if(p.getpId()==0){
                p.setOpen("true");
            }
        }

        for(Promission p : rolePromission){
            for(Promission allp : promissions){
                if(p.getId()==allp.getId()){
                    allp.setChecked("true");
                }
            }
        }
        return promissions;
    }

    @ResponseBody
    @RequestMapping("loadPromissionJson")
    public List<Promission> loadPromissionJson(int rid){
        List<Promission> promissionList=promissionService.loadPromissionByRoleIdJson(rid);
        System.out.println(promissionList);
        return promissionList;
    }
}
