package com.anjali.QuizService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

	@GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestion(@RequestParam String categoryName,@RequestParam Integer numQuestions);
	
	@PostMapping("/getQuestion")
	public ResponseEntity<List<QuestionWrapper>> getQuestionfromId(@RequestBody List<Integer>questionIds);
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
		
	
	
}
