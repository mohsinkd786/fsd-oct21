package com.mohsinkd786.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/home",produces = MediaType.APPLICATION_XML_VALUE)
    public String sayHello(){
        return "Hello world";
    }

}
