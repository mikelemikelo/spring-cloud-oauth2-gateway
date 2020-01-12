package com.mikele.microservices.clients.controllers;

import com.mikele.microservices.feignclients.ClientOneFeign;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;

@Controller
public class CallingFeignClientController {


    private ClientOneFeign clientOneFeign;

    public CallingFeignClientController(ClientOneFeign clientOneFeign){
        this.clientOneFeign = clientOneFeign;
    }


    @PostConstruct
    public void init() {


        System.out.println("Running process once the beam has been constructed. ");

        try{
            String clientOneResponse = this.clientOneFeign.clientOne("client-one");
            System.out.println("Call Worked fine first Client response: " + clientOneResponse);
        }catch (Exception ex){
            System.out.println("ISSUE with Feign client");
            ex.printStackTrace();
        }
    }


    @GetMapping("/")
    @ResponseBody
    public String secondClient(){
        System.out.println("Calling Fiest Client from second service");
        return "Working second client";
    }


    @GetMapping("/clienttwo")
    @ResponseBody
    public String secondClientFeign(){
        System.out.println("CAlling Fiest Client from second service");
        try{
            String clientOneResponse = this.clientOneFeign.clientOne("client-one");
            System.out.println("Call Worked fine Fiest Client response: " + clientOneResponse);
        }catch (Exception ex){
            System.out.println("ISSUE with Feign client");
            ex.printStackTrace();
        }

        return "Working second client";
    }

}
