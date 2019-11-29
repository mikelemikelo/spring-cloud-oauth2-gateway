package com.mikele.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {

    public static void main(final String[] args) { SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * Oauth2 token filter.
     */
    //@Autowired
    //private TokenRelayGatewayFilterFactory filterFactory;


    /**
     * Method in charge of attaching to reach request going to model-manage, the Oauth2 JWT tokens.
     * @param builder - RouteLocatorBuilder.
     * @return - Updated RouteLocator with filter that adds the Oath2 JWT token to each request (if any).
     */
    //@Bean
    /*
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("api_calls_model_manage", (r) ->
                        r.path("/**")
                                .filters(f ->f.filters(filterFactory.apply()).removeRequestHeader("Cookie")
                                )
                                .uri("http://localhost:8090/")).build();
    }

     */

}
