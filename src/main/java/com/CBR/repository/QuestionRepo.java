package com.CBR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CBR.enity.Question;



@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer>{
	
	List<Question> findQuestionsByTrongSo(int trongSo);
	Question findQuestionById(int id);
	@Query(value = "SELECT DISTINCT cauhoi.id, cauhoi.cauhoi, cauhoi.trongso FROM cauhoi " +
			"JOIN cautraloi ON cauhoi.id = cautraloi.idcauhoi " +
			"JOIN motacase ON motacase.idcautraloi = cautraloi.id " +
			"JOIN ketluan ON motacase.idcase = ketluan.id " +
			"WHERE trongso = ?1 AND ketluan.hethong = ?2 ", nativeQuery = true)
	List<Question> findQuestionsByTrongSoAndHeThong(int trongSo, String heThong);
}
