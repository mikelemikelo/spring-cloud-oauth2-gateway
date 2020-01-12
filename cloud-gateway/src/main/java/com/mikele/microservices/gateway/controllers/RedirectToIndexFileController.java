package com.mikele.microservices.gateway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.RedirectView;

@Controller
public class RedirectToIndexFileController {

    @GetMapping("/")
    public RedirectView redirect() {
        return new RedirectView("/index.html");
    }



}
