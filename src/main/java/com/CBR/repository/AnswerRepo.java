package com.CBR.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CBR.enity.Answer;

@Repository
public interface AnswerRepo extends JpaRepository<Answer, Integer>{

	Answer findAnswerByCauTraLoi(String answer);
	List<Answer> findAnswersByQuestion_Id(int  idQuestion);

	@Query(value = "SELECT DISTINCT ketluan.hethong \n" +
			"FROM cautraloi " +
			"JOIN motacase ON cautraloi.id = motacase.idcautraloi " +
			"JOIN ketluan ON ketluan.id = motacase.idcase " +
			"WHERE cautraloi = ?1", nativeQuery = true)
	String findHeThongByCauTraLoi(String answer);

	@Query(value = "SELECT cautraloi.cautraloi " +
			"FROM cauhoi " +
			"JOIN cautraloi ON cauhoi.id = cautraloi.idcauhoi " +
			"JOIN motacase ON cautraloi.id = motacase.idcautraloi " +
			"JOIN ketluan ON motacase.idcase = ketluan.id " +
			"WHERE ketluan.hethong = ?1", nativeQuery = true)
	List<String> getListAnswerInCaseByHeThong(String heThong);

	@Query(value = "SELECT cauhoi.trongso " +
			"FROM cauhoi " +
			"JOIN cautraloi ON cauhoi.id = cautraloi.idcauhoi " +
			"WHERE cautraloi = ?1", nativeQuery = true)
	int getTrongSoByAnswer(String ans);
	@Query(value = "SELECT cautraloi.* " +
			"FROM cautraloi " +
			"JOIN cauhoi ON cauhoi.id = cautraloi.idcauhoi " +
			"WHERE cauhoi.trongso = ?1 ", nativeQuery = true)
	List<Answer> findAnswerByTrongSo(int trongSo);

}
