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
    public Map<Map<Question, List<Answer>>, String> findQuestionDetailAndAnswer(String heThong) {
        Map<Map<Question, List<Answer>>, String> map = new HashMap<>();
        Map<Question, List<Answer>> m = new HashMap<>();
        List<Question> listQuestion = questionServiceImpl.findQuestionsByTrongSoAndHeThong(5, heThong);
        for(Question question : listQuestion){
            m.put(question, findAnswersByQuestion(question.getId()));
        }
        String heThong1 = null;
        switch (heThong) {
            case "Phanh":
                heThong1 = "phanh";
                break;
            case "Chuyển động":
                heThong1 = "chuyenDong";
                break;
            case "Điện":
                heThong1 = "dien";
                break;
            default:
                heThong1 = "dongCo";
                break;
        }
        map.put(m, heThong1);
        return map;
    }
}
