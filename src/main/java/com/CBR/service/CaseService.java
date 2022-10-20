package com.CBR.service;

import com.CBR.model.*;

import java.util.List;

public interface CaseService {

    List<ChuyenDongForm> getAllCaseChuyenDong();
    List<DienForm> getAllCaseDien();
    List<DongCoForm> getAllCaseDongCo();
    List<Form> getAllCaseKhiThai();
    List<Form> getAllCaseTruyenLuc();
    List<PhanhForm> getAllCasePhanh();

}
