package com.opot.count.controller;


import com.opot.count.entity.Count;
import com.opot.count.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("count")
public class CountController {

    @Autowired
    private CountService countService;

    /**
     * 计算用户的总数
     * @return
     */
    @GetMapping("countUsers")
    @ResponseBody
    public long getUserNums(){
        return countService.getUsersNum();
    }

    /**
     * 获取某一天的搜索总量
     * @return
     */
    @GetMapping("getDayNum")
    @ResponseBody
    public long getDayNum(@RequestParam(value = "day") int day){
        return countService.getDaySearchNum(day);
    }


    /**
     * 计算用户最近三天的搜索数量
     * @return
     */
    @GetMapping("getUserInfo")
    @ResponseBody
    public List<Count> getUserInfo(){
        List<Integer> uid = countService.getDayUsers();
        List<Count> userInfo = new ArrayList<>();
        for (Integer i:uid
             ) {
            userInfo.add(countService.getUserInfo(i));
        }
        return userInfo;

    }


}
