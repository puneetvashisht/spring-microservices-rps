package com.rps.workoutactiveservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@Profile("test")
public class WorkoutActiveServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkoutActiveServiceApplication.class, args);
	}

}
