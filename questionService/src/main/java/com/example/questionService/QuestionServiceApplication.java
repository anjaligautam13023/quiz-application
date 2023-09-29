package com.example.questionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class QuestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionServiceApplication.class, args);
	}
}
