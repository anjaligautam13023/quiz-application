package com.example.loginsignup;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;



@RestController

public class controller {
    @Autowired
    private secrepo sp;
    @GetMapping("/home")
  public String temp()
  {
      return "hi";
  }

@PostMapping("/Login")
public ResponseEntity<UserCredential> Login(@RequestParam String email,@RequestParam String password){
    UserCredential temp=sp.findByEmail(email);
       if(temp!=null)
       {
           return new ResponseEntity<>(sp.findByEmail(email), HttpStatus.OK);
       }


       return new ResponseEntity<>(null,HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping("/Register")
    public ResponseEntity<UserCredential> Register(@RequestBody UserCredential userCredential ){
        UserCredential temp=sp.findByEmail(userCredential.getEmail());
        if(temp!=null)
        {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
       sp.save(userCredential);

        return new ResponseEntity<>(userCredential,HttpStatus.OK);
    }




}
