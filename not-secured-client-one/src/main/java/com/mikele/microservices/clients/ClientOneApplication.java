package com.mikele.microservices.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientOneApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ClientOneApplication.class, args);
    }

}
