package com.folksdevssecurity.inmemorysecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping
    public String helloWorld(){

        return "Hello from public endpoint " ;
    }
    @PreAuthorize("hasRole('ananymouser')")
    @GetMapping("/getRole")
    public String getRole(){
        return "Yetki Düzeyiniz";
    }
}
