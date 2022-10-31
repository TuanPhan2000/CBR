package com.CBR.repository;

import com.CBR.enity.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepo extends JpaRepository<Case, Integer> {

    Case findCaseById(int id);

}
