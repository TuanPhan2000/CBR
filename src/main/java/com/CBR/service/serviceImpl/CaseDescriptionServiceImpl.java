package com.CBR.service.serviceImpl;

import com.CBR.enity.CaseDescription;
import com.CBR.repository.CaseDescriptionRepo;
import com.CBR.service.CaseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseDescriptionServiceImpl implements CaseDescriptionService {

    @Autowired
    CaseDescriptionRepo caseDescriptionRepo;

    @Override
    public List<CaseDescription> findCaseDescriptionsByIdAnswer(int id) {
        return caseDescriptionRepo.findCaseDescriptionsByIdAnswer(id);
    }
}
