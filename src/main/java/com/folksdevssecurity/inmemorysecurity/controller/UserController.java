package com.folksdevssecurity.inmemorysecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @GetMapping()
    public String getUser(){

        return "Welcome to the Home Page "  ;
    }
    //@PreAuthorize("hasAuthority('USER')")
    @GetMapping("/user")
    public String getUserRole(){

        return "Welcome to the Home Page USER Role "   ;
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdminRole(){

        return "Welcome to the Home Page ADMİN Role "   ;
    }
}
