package com.CBR.controller;

import com.CBR.dto.CaseDTO;
import com.CBR.model.Solution;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carfault")
public class CaseController {

    @PostMapping("/submitCase")
    public ResponseEntity<Solution> solution(@RequestBody CaseDTO caseDTO){

        

    }

}
