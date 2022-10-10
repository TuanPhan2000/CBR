package com.CBR.service;

import java.util.List;

import com.CBR.enity.Question;

public interface QuestionService {
	
	List<Question> findQuestionByTrongSo(int trongSo);
	Question findQuestionById(int id);
	List<Question> findQuestionsByTrongSoAndHeThong(int trongSo, String heThong);

}
