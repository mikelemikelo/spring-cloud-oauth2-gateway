package com.mikele.microservices.feignclients.conf;
/*

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

 */

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Arrays;


/*
Open feign client configuration definition.
 */
@Configuration
public class Oauth2FeignClientConf {

    public OAuth2ProtectedResourceDetails resource() {
        //@formatter:off
        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        resourceDetails.setClientId("model-manage");
        resourceDetails.setClientSecret("model-manage-secret");
        //https://localhost:8080/uaa/login/oauth/access_token
        resourceDetails.setAccessTokenUri("http://localhost:9090/uaa/oauth/token");
        //resourceDetails.setAccessTokenUri("http://localhost:9090/uaa/oauth/authorize");
        //@formatter:on
        return resourceDetails;
    }

    @LoadBalanced
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate() {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(this.resource());
        oAuth2RestTemplate.getAccessToken();
        System.out.println("CustomFeignInterceptor Value " + oAuth2RestTemplate.getAccessToken().getValue());
        return oAuth2RestTemplate;
    }

    //@Bean
    public RequestInterceptor requestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
        return requestTemplate -> {

            //requestTemplate.header("Authorization" , "Bearer " + oAuth2RestTemplate.getAccessToken().getValue());
            requestTemplate.header("Authorization" , "Bearer " + oAuth2RestTemplate.getAccessToken().getValue());
            requestTemplate.header("content-type" , "application/json");
            requestTemplate.header("grant_type" , "client_credentials");
            StringBuffer str = new StringBuffer();
            str.append("\n FROM FEIGN CLIENT { \n\n");

            str.append("=@#-> +++++++ REQUEST PATH " + requestTemplate.path() + " \n");
            requestTemplate.headers().keySet().stream().forEach(headerKey -> {
                str.append("=@#-> Header Key: " + headerKey + " ,value:-> " + requestTemplate.headers().get(headerKey) + " <- \n");
            });
            str.append("=@#->-> REQUEST URL " + requestTemplate.url() + " \n");
            str.append("=@#->->+++++++ requestTemplate.request().toString() " + requestTemplate.request().toString() + " \n");
            str.append("=@#->->+++++++ requestTemplate.request().httpMethod() " + requestTemplate.request().httpMethod().name() + " \n");

            str.append("\n } \n\n");

            System.out.println(str.toString());

        };
    }

    @Bean
    //RequestInterceptor oauth2FeignRequestInterceptor(ClientCredentialsResourceDetails clientCredentialDetails) {
    RequestInterceptor oauth2FeignRequestInterceptor() {
        //return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), resource());
        DefaultOAuth2ClientContext oauthClientContext = new DefaultOAuth2ClientContext();

        return new OAuth2FeignRequestInterceptor(oauthClientContext, resource());
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }



}
