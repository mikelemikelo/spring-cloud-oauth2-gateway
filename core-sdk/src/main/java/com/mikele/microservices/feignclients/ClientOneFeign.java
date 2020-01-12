package com.mikele.microservices.feignclients;


import com.mikele.microservices.feignclients.conf.Oauth2FeignClientConf;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "client-one-feign" , url = "http://localhost:8090/", configuration = Oauth2FeignClientConf.class)
public interface ClientOneFeign {

    @RequestMapping(value = "/client-one", method = RequestMethod.GET)
    @ResponseBody
    String clientOne();

    @RequestMapping(value = "/{instance}/clientone", method = RequestMethod.GET)
    @ResponseBody
    String clientOne(@PathVariable("instance") String instance);

}
