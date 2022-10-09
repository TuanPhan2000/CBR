package com.CBR.controller;

import com.CBR.enity.Answer;
import com.CBR.service.serviceImpl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carfault")
public class AnswerController {

    @Autowired
    AnswerServiceImpl answerServiceImpl;

    @GetMapping("/findAnswerByQuestion/{idQuestion}")
    public ResponseEntity<List<Answer>> findAnswerByQuestion(@PathVariable(name = "idQuestion") int idQuestion){
  
        List<Answer> list = answerServiceImpl.findAnswersByQuestion(idQuestion);
        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
