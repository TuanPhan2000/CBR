package com.CBR.service;

import com.CBR.enity.Answer;
import java.util.List;

public interface AnswerService {

    List<Answer> findAnswersByQuestion(int idQuestion);

    String findHeThongByCauTraLoi(String answer);
}
