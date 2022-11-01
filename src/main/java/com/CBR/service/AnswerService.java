package com.CBR.service;

import com.CBR.enity.Answer;
import com.CBR.enity.Question;

import java.util.List;
import java.util.Map;

public interface AnswerService {
    Answer findAnswerByCauTraLoi(String answer);

    List<Answer> findAnswersByQuestion(int idQuestion);

    String findHeThongByCauTraLoi(String answer);

    List<String> getListAnswerInCaseByHeThong(String heThong);
    int getTrongSoByAnswer(String ans);
    List<Answer> findAnswerByTrongSo(int trongSo);
    Map<Map<Question, List<Answer>>, String> findQuestionDetailAndAnswer(String heThong);
}
