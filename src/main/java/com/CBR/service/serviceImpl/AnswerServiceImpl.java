package com.CBR.service.serviceImpl;

import com.CBR.enity.Answer;
import com.CBR.repository.AnswerRepo;
import com.CBR.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepo answerRepo;

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
}
