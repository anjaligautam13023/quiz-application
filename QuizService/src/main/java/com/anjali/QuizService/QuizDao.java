package com.anjali.QuizService;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizDao extends MongoRepository<quiz, String>
{

	Optional<quiz> findByno(Integer id);

	
    
}
