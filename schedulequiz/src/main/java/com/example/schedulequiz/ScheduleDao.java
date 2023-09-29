package com.example.schedulequiz;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ScheduleDao extends MongoRepository<Scheduledquiz, String>
{

	Optional<ScheduleDao> findByid(Integer id);


	Scheduledquiz findByquestionid(Integer id);
}
