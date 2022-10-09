package com.CBR.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CBR.enity.Question;
import com.CBR.service.serviceImpl.QuestionServiceImpl;

@RestController
@RequestMapping("/api/carfault")
public class QuestionController {

	@Autowired
	QuestionServiceImpl questionServiceImpl;

	@GetMapping("/findQuestionByTrongSo/{trongSo}")
	public ResponseEntity<List<Question>> findQuestionByTrongSo(@PathVariable(name = "trongSo") int trongSo){

		List<Question> listQuestionByTrongSo = questionServiceImpl.findQuestionByTrongSo(trongSo);
		if(listQuestionByTrongSo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listQuestionByTrongSo, HttpStatus.OK);

	}
	

	
}
