package com.CBR.service;

import com.CBR.enity.CaseDescription;

import java.util.List;

public interface CaseDescriptionService {
    List<CaseDescription> findCaseDescriptionsByIdAnswer(int id);
}
