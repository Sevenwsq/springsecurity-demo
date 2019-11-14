package com.qiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Silent
 * @date 2019/11/13 16:52:35
 * @description
 */
@Controller
public class RouterController {
    @RequestMapping({"/","index","index.html"})
    public String index(){
        return "index";
    }
    @RequestMapping("/level1/{id}")
    public String level1(@PathVariable("id") int id){
        return "views/level1/" + id;
    }
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/" + id;
    } @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/" + id;
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }
}
