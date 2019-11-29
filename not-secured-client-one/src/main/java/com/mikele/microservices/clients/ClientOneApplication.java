package com.mikele.microservices.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableEurekaClient
//@EnableResourceServer
public class ClientOneApplication {

    public static void main(final String [] args){
        SpringApplication.run(ClientOneApplication.class, args);
    }

}
