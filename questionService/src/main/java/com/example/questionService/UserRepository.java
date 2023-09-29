package com.example.questionService;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<quizquest, String> {
    
	List<quizquest> findBytopicIn(String category);
    
	
	 
	List<quizquest> findRandomObjectBytopic(String topic);



	List<quizquest> findQnoByTopic(String Topic);



	quizquest findByQno(Integer id);
    





	
 
}
