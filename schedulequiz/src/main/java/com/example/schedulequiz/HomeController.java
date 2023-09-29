package com.example.schedulequiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {
    @Autowired
    QuizInterface quizinterface;

    @Autowired
    ScheduleDao sDao;
    @PostMapping("/schedulequiz")
    public ResponseEntity<Integer> createQuiz(@RequestParam String category, @RequestParam(defaultValue = "0") int numQ, @RequestParam String stdate, @RequestParam String endate,@RequestParam String title) {

        List<Integer> quizquests = quizinterface.getQuestion(category, numQ).getBody();

        Scheduledquiz s= new Scheduledquiz();
        s.setQuestionids(quizquests);
        s.setTitle(title);
        s.setQno(numQ);
        s.setTopic(category);
        s.setStdate(stdate);
        s.setEndate(endate);
        s.setId(quizquests.hashCode());
        sDao.save(s);
        int quizId = s.getId();
        System.out.println(quizId);
        return new ResponseEntity<>(quizId, HttpStatus.CREATED);
        }


    @GetMapping("/getAllscheduled")
    public ResponseEntity<List<Scheduledquiz>> getAllscheduledata() {
        try {
            return new ResponseEntity<>(sDao.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("get/{id}")
    public  ResponseEntity<List<QuestionWrapper>>  getquizquest(@PathVariable Integer id) {
       Scheduledquiz s= sDao.findByquestionid(id);
        List<Integer> quesfromdb = s.getQuestionids();
        ResponseEntity<List<QuestionWrapper>> question = quizinterface.getQuestionfromId(quesfromdb);
        return question;

    }


}
