package com.example.loginsignup;

import org.springframework.data.mongodb.repository.MongoRepository;




public interface secrepo extends MongoRepository<UserCredential,String> {



    UserCredential findByEmail(String email);
}
