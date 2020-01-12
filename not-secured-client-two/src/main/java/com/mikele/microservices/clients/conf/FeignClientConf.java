package com.mikele.microservices.clients.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

@Configuration
public class FeignClientConf {

    @Bean
    public BaseOAuth2ProtectedResourceDetails clientCredentialDetails() {

        ClientCredentialsResourceDetails resourceDetails = new ClientCredentialsResourceDetails();
        //ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
        resourceDetails.setClientId("gateway-service");
        resourceDetails.setClientSecret("gateway-service-secret");
        resourceDetails.setAccessTokenUri("http://localhost:9090/uaa/oauth/token");
        //resourceDetails.setAccessTokenUri(accessTokenUri);
        //resourceDetails.setClientId(clientId);
        //resourceDetails.setClientSecret(clientSecret);
        //resourceDetails.setGrantType("password");
        //resourceDetails.setScope(Arrays.asList(scope));
        return resourceDetails;
    }
}
