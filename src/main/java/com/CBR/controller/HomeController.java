package com.CBR.controller;

import com.CBR.constain.StaticVariable;
import com.CBR.enity.Answer;
import com.CBR.enity.Log;
import com.CBR.enity.Question;
import com.CBR.model.Solution;
import com.CBR.service.serviceImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    AnswerServiceImpl answerServiceImpl;

    @Autowired
    CaseServiceImpl caseServiceImpl;

    @Autowired
    QuestionServiceImpl questionServiceImpl;

    @Autowired
    SolutionServiceImpl solutionServiceImpl;
    @Autowired
    LogServiceImpl logServiceImpl;
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("answers", answerServiceImpl.findAnswerByTrongSo(6));
        return "index";
    }

    @PostMapping("/submitGeneralInfor")
    public String getPageDetail(Model model,
                                @RequestParam("hangXe") String hangXe,
                                @RequestParam("tenXe") String tenXe,
                                @RequestParam("doiXe") String doiXe,
                                @RequestParam("loiGapPhai") String loiGapPhai,
                                @RequestParam("khac") String khac){

        if(!khac.equals("")){
            Log log = new Log();
            log.setMota(khac);
            log.setThoigian(LocalDate.now());
            String noted = "";
            if(logServiceImpl.saveLog(log)){
                noted = "Hệ thống đã tiếp nhận và sẽ xử lý sơm nhất";
            }
            else noted = "Xử lý thất bại";
            model.addAttribute("noted", noted);
            return "index";
        }
        if(loiGapPhai.equals("")){
            return "redirect:/";
        }
        caseServiceImpl.setAttributeCaseInputGeneral(hangXe, tenXe, doiXe, loiGapPhai);

        String heThong = answerServiceImpl.findHeThongByCauTraLoi(loiGapPhai);
        if(heThong.equals("Khí thải") || heThong.equals("Truyền lực")){
            Solution solution = solutionServiceImpl.findSolutionTruyenLucOrKhiThai(StaticVariable.system, answerServiceImpl.findHeThongByCauTraLoi(loiGapPhai));
            model.addAttribute("solution", solution);
            return "index";
        }
        Map<Map<Question, List<Answer>>, String> map = answerServiceImpl.findQuestionDetailAndAnswer(answerServiceImpl.findHeThongByCauTraLoi(loiGapPhai));
        model.addAttribute("map", map);
        return "index";
    }


}
