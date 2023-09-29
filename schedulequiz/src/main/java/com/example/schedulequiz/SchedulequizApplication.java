package com.example.schedulequiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@EnableFeignClients
@SpringBootApplication
public class SchedulequizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulequizApplication.class, args);
	}




}
