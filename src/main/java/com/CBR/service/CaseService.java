package com.CBR.service;

import com.CBR.enity.Case;
import com.CBR.model.*;

import java.util.List;

public interface CaseService {

    List<ChuyenDongForm> getAllCaseChuyenDong();
    List<DienForm> getAllCaseDien();
    List<DongCoForm> getAllCaseDongCo();
    List<Form> getAllCaseKhiThai();
    List<Form> getAllCaseTruyenLuc();
    List<PhanhForm> getAllCasePhanh();

    void setAttributeCaseInputGeneral(String hangXe, String tenXe, String doiXe, String loiGapPhai);
    Case findCaseById(int id);

}
