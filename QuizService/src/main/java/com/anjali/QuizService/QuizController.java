package com.anjali.QuizService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

	@Autowired
	QuizInterface quizinterface;

	@Autowired
	QuizDao quizDao;

	@PostMapping("/create")
	public ResponseEntity<Integer> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
		List<Integer> quizquests = quizinterface.getQuestion(category, numQ).getBody();
		quiz q = new quiz();
		q.setTitle(category);
		q.setId(quizquests.hashCode());
		q.setQuestion(quizquests);
		quizDao.save(q);
		int quizId = q.getId();
		System.out.println(quizId);
		return new ResponseEntity<>(quizId, HttpStatus.CREATED);
	}

	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getquizquest(@PathVariable Integer id) {
		quiz q = quizDao.findByno(id).get();
		List<Integer> quesfromdb = q.getQuestion();
		ResponseEntity<List<QuestionWrapper>> question = quizinterface.getQuestionfromId(quesfromdb);
		return question;
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {

		ResponseEntity<Integer> score = quizinterface.getScore(responses);
		return score;

	}
}
