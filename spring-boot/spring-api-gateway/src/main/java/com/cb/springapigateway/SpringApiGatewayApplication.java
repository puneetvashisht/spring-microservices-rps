package com.cb.springapigateway;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.cb.springapigateway.configurations.AuthenticationFilter;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringApiGatewayApplication {
	
	@Autowired
	AuthenticationFilter authFilter;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGatewayApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//@formatter:off
		return builder.routes()
				.route("workout-service", r -> r.path("/api/v1/workouts/**")
						//Validating token
						.filters(f -> f.filter(authFilter))
//						.filters(f1 -> f1.filter(yourOwnFilter))
						.uri("lb://workout-service"))
				.route("workout-active-service", r -> r.path("/api/v1/workoutactive/**")
						.filters(f -> f.filter(authFilter))
						.uri("lb://workout-active-service"))
				.route("auth", r -> r.path("/auth/**")
						.uri("lb://auth"))
				
				.build();
		//@formatter:on
	}
	
	@Bean
	SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
		return http.
				csrf(csrf-> csrf.disable())
				.build();
	}

}
