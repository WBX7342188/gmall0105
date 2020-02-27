package com.atguigu.gmall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ItemController {
    @RequestMapping("index")
    //@ResponseBody
    public String index(ModelMap modelMap){
        List list =new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("循环"+i);
        }
        modelMap.put("list",list);
        modelMap.put("hello","hello mobile!!");
        return "index";
    }

}
