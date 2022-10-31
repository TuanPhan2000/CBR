package com.CBR.service.serviceImpl;

import com.CBR.constain.StaticVariable;
import com.CBR.model.*;
import com.CBR.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    AnswerServiceImpl answerServiceImpl;


    @Override
    public List<ChuyenDongForm> getAllCaseChuyenDong() {
        List<ChuyenDongForm> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Chuyển động");
        for(int i = 0; i < listAnswer.size(); i += 7){
            listCase.add(new ChuyenDongForm(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3), listAnswer.get(i+4), listAnswer.get(i+5), listAnswer.get(i+6)));
        }
        return listCase;
    }

    @Override
    public List<DienForm> getAllCaseDien() {
        return null;
    }

    @Override
    public List<DongCoForm> getAllCaseDongCo() {
        return null;
    }

    @Override
    public List<Form> getAllCaseKhiThai() {
        return null;
    }

    @Override
    public List<Form> getAllCaseTruyenLuc() {
        return null;
    }

    @Override
    public List<PhanhForm> getAllCasePhanh() {
        return null;
    }
    @Override
    public void setAttributeCaseInputGeneral(String hangXe, String tenXe, String doiXe, String loiGapPhai) {
        StaticVariable.form.setHangXe(hangXe);
        StaticVariable.form.setTenXe(tenXe);
        StaticVariable.form.setDoiXe(doiXe);
        StaticVariable.form.setLoiGapPhai(loiGapPhai);
    }

}
