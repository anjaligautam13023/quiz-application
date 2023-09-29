package com.example.questionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.questionService.quizquest;

@RestController
public class homecontroller {
	@Autowired
	UserRepository userrepository;
	
	@GetMapping("/")
	public String home() {
		
		  return "Hi , from my side";
	}
	
	@GetMapping("/Allquestion")
	public ResponseEntity<List<quizquest>> getdata() {
		try {
			return new ResponseEntity<>(userrepository.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{category}")
	public ResponseEntity<List<quizquest>> getdatabycategoy(@PathVariable String category) {
		try {
			return new ResponseEntity<>(userrepository.findBytopicIn(category),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);		
	}



	@PostMapping(value="/addquestion")
	public ResponseEntity<Integer> addquestion(@RequestBody quizquest q)
	{

	  System.out.print(q);
	  userrepository.save(q);
	  int Questionid = q.getQno();

	  return new ResponseEntity<>(Questionid,HttpStatus.CREATED);
	}
	
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestion(@RequestParam String categoryName,@RequestParam Integer numQuestions){
		
		List<quizquest>quizquests=userrepository.findQnoByTopic(categoryName);
	    Collections.shuffle(quizquests);
		List<quizquest> randomNumbers = quizquests.subList(0, numQuestions);
		System.out.println(randomNumbers);
		List<Integer> qNos = randomNumbers.stream().map(quiz->quiz.getQno()).collect(Collectors.toList());
		return  new ResponseEntity<>(qNos,HttpStatus.OK);
	  
		
	}
	//http://localhost:8085/getQuestion?questionIds=2&questionIds=3&questionIds=4&questionIds=6&questionIds=9
	@PostMapping("/getQuestion")
	public ResponseEntity<List<QuestionWrapper>> getQuestionfromId(@RequestBody List<Integer>questionIds)
	{   System.out.println(questionIds);
		List<QuestionWrapper> wrappers=new ArrayList<>();
		List<quizquest> questionsList=new ArrayList<>();
		for(Integer id:questionIds) {
			questionsList.add(userrepository.findByQno(id));
		}
		System.out.println(questionsList);
		  for(quizquest question:questionsList) {
		   QuestionWrapper wrapper=new QuestionWrapper();
		   wrapper.set_id(question.get_id());
		   wrapper.setQuestion(question.getQuestion());
		   wrapper.setQno(question.getQno());
		   wrapper.setA(question.getA());
		   wrapper.setB(question.getB());
		   wrapper.setC(question.getC());
		   wrapper.setD(question.getD());
		   wrappers.add(wrapper);
		}
	  return new ResponseEntity<>(wrappers,HttpStatus.OK);
	}
	
	@PostMapping("/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
	 	int right=0;
	  	for(Response response:responses) {
	  		quizquest question= userrepository.findByQno(response.getQno());
	  		if(response.getResponse().equals(question.getAnswer())) 
	  			 right++;
	  	
	  	}
	  	return new ResponseEntity<>(right,HttpStatus.OK);
		
	}
   }

