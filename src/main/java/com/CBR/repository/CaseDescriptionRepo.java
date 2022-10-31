package com.CBR.repository;

import com.CBR.enity.CaseDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseDescriptionRepo extends JpaRepository<CaseDescription, Integer> {

    @Query(value = "SELECT motacase.* " +
            "FROM motacase " +
            "JOIN cautraloi ON cautraloi.id = motacase.idcautraloi " +
            "WHERE cautraloi.id = ?1 ", nativeQuery = true)
    List<CaseDescription> findCaseDescriptionsByIdAnswer(int id);

}
