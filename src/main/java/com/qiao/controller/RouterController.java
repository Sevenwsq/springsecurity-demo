package com.qiao.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

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
    @PreAuthorize("hasAuthority('vip1')")//拥有vip1权限可以访问
    //@PreAuthorize("hasAnyAuthority('vip1','vip2')")//拥有vip1或者vip2中的一个权限可以访问
    public String level1(@PathVariable("id") int id){
        return "views/level1/" + id;
    }
    @PreAuthorize("hasAuthority('vip2')")
    @RequestMapping("/level2/{id}")
    public String level2(@PathVariable("id") int id){
        return "views/level2/" + id;
    }
    @PreAuthorize("hasAuthority('vip3')")
    @RequestMapping("/level3/{id}")
    public String level3(@PathVariable("id") int id){
        return "views/level3/" + id;
    }
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping(value = "/login-success")
    public String loginSuccess() {
        //当前通过认证的用户身份
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String name = authentication.getName();
        System.out.println("Authentication:用户名：" + name);
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails)principal;
            System.out.println("UserDetails:用户名：" + userDetails.getUsername());
            System.out.println("密码：" + userDetails.getPassword());
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            authorities.forEach((authority)->System.out.println("用户身份"+authority));

        } else {
            System.out.println("principal" + principal.toString());
        }
        return "redirect:/";
    }
}
