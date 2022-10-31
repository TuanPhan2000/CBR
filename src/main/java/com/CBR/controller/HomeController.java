package com.CBR.controller;

import com.CBR.constain.StaticVariable;
import com.CBR.enity.Answer;
import com.CBR.enity.Question;
import com.CBR.service.serviceImpl.AnswerServiceImpl;
import com.CBR.service.serviceImpl.CaseServiceImpl;
import com.CBR.service.serviceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

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
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("answers", answerServiceImpl.findAnswerByTrongSo(6));
        return "index";
    }

    @PostMapping("/submitGeneralInfor")
    public String getPageDetail(Model model, RedirectAttributesModelMap redirectAttributes,
                                @RequestParam("hangXe") String hangXe,
                                @RequestParam("tenXe") String tenXe,
                                @RequestParam("doiXe") String doiXe,
                                @RequestParam("loiGapPhai") String loiGapPhai){
        caseServiceImpl.setAttributeCaseInputGeneral(hangXe, tenXe, doiXe, loiGapPhai);
        Map<Question, List<Answer>> map = answerServiceImpl.findQuestionDetailAndAnswer(answerServiceImpl.findHeThongByCauTraLoi(loiGapPhai));
        redirectAttributes.addAttribute("map", map);
        return "redirect:/";
    }

}
