package com.CBR.service;

import java.util.List;

import com.CBR.enity.Question;

public interface QuestionService {
	
	List<Question> findQuestionByTrongSo(int trongSo);
	Question findQuestionById(int id);
}
