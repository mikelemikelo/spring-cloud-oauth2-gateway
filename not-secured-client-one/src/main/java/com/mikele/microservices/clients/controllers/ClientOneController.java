package com.mikele.microservices.clients.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientOneController {

    @GetMapping("/")
    @ResponseBody
    public String clientOne(){
        System.out.println("Client one responding");
        return "Hello Client One";
    }


    @GetMapping("/clientone")
    @ResponseBody
    public String clientOneWithParameter(){
        System.out.println("Client one responding with Parameter");
        return "Hello Client One with arguments";
    }

}
