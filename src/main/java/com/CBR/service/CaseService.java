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
    void setAttributeCaseSystemMotionInput(String oToKhiDiDuongPhang, String khungXeKhiQuaDuongNhapNho, String tinhTrangLop);
    void setAttributeCaseBrakeSystemInput(String tuoiThoMaPhanh, String xeBiCanKhiThaPhanh, String mucDauPhanh);
    void setAttributeCaseEngineSystemInput(String tuoiThoAccquy, String tuoiThoBugi, String tiengDongLaTrongKhoangMay, String mucXangCuaBauPhao);
    void setAttributeCasePowerSystemInput(String tuoiThoAccquy, String tuoiThoMayPhatDien, String denPhaOto, String oCamCapDienKhong, String tiengKeuLaLucDeCuaOto);
    Case findCaseById(int id);

}
