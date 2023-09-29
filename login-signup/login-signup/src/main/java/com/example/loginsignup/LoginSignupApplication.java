package com.example.loginsignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class LoginSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSignupApplication.class, args);
	}

}
