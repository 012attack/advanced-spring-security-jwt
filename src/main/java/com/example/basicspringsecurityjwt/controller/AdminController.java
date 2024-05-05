package com.example.basicspringsecurityjwt.controller;

import com.example.basicspringsecurityjwt.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.Collection;

@Controller
@ResponseBody
public class AdminController {

    @GetMapping("/admin")
    public String adminP(@AuthenticationPrincipal UserDetails userDetails){

        return userDetails.getUsername() + " call api";
    }
}
