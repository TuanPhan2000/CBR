package com.CBR.controller;

import com.CBR.service.serviceImpl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    AnswerServiceImpl answerServiceImpl;
    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("answers", answerServiceImpl.findAnswerByTrongSo(6));
        return "index";
    }

}
