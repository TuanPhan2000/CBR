package com.CBR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CBR.enity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer>{

	List<Answer> findAnswersByQuestion_Id(int  idQuestion);

	@Query(value = "SELECT DISTINCT ketluan.hethong \n" +
			"FROM cautraloi " +
			"JOIN motacase ON cautraloi.id = motacase.idcautraloi " +
			"JOIN ketluan ON ketluan.id = motacase.idcase " +
			"WHERE cautraloi = ?1", nativeQuery = true)
	String findHeThongByCauTraLoi(String answer);
}
