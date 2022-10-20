package com.CBR.controller;


import com.CBR.model.ChuyenDongForm;
import com.CBR.model.Solution;
import com.CBR.service.serviceImpl.CaseServiceImpl;
import com.CBR.service.serviceImpl.SolutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carfault")
public class CaseController {

    @Autowired
    SolutionServiceImpl solutionServiceImpl;

    @PostMapping("/submitCaseChuyenDong")
    public ResponseEntity<Solution> caseChuyenDong(@RequestBody ChuyenDongForm chuyenDongForm){
        return new ResponseEntity<>(solutionServiceImpl.findSolutionChuyenDong(chuyenDongForm), HttpStatus.OK);
    }

}
