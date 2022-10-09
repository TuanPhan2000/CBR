package com.CBR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CBR.enity.Question;



@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	
	List<Question> findQuestionsByTrongSo(int trongSo);
	Question findQuestionById(int id);
}
