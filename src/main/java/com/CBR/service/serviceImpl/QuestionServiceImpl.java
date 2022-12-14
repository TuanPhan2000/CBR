package com.CBR.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CBR.enity.Question;
import com.CBR.repository.QuestionRepo;
import com.CBR.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepo questionRepo;

	@Override
	public List<Question> findQuestionByTrongSo(int trongSo) {
		return questionRepo.findQuestionsByTrongSo(trongSo);
	}

	@Override
	public Question findQuestionById(int id) {
		return questionRepo.findQuestionById(id);
	}

	@Override
	public List<Question> findQuestionsByTrongSoAndHeThong(int trongSo, String heThong) {
		return questionRepo.findQuestionsByTrongSoAndHeThong(trongSo, heThong);
	}

}
