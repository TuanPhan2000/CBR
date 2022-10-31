package com.CBR.service.serviceImpl;

import com.CBR.enity.Answer;
import com.CBR.enity.Question;
import com.CBR.repository.AnswerRepo;
import com.CBR.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;

    @Autowired
    QuestionServiceImpl questionServiceImpl;

    @Override
    public Answer findAnswerByCauTraLoi(String answer) {
        return answerRepo.findAnswerByCauTraLoi(answer);
    }

    @Override
    public List<Answer> findAnswersByQuestion(int idQuestion) {
        return answerRepo.findAnswersByQuestion_Id(idQuestion);
    }

    @Override
    public String findHeThongByCauTraLoi(String answer) {
        return answerRepo.findHeThongByCauTraLoi(answer);
    }

    @Override
    public List<String> getListAnswerInCaseByHeThong(String heThong) {
        return answerRepo.getListAnswerInCaseByHeThong(heThong);
    }

    @Override
    public int getTrongSoByAnswer(String ans) {
        return answerRepo.getTrongSoByAnswer(ans);
    }

    @Override
    public List<Answer> findAnswerByTrongSo(int trongSo) {
        return answerRepo.findAnswerByTrongSo(trongSo);
    }

    @Override
    public Map<Question, List<Answer>> findQuestionDetailAndAnswer(String heThong) {
        Map<Question, List<Answer>> map = new HashMap<>();
        List<Question> listQuestion = questionServiceImpl.findQuestionsByTrongSoAndHeThong(5, heThong);
        for(Question question : listQuestion){
            map.put(question, findAnswersByQuestion(question.getId()));
        }
        return map;
    }
}
