package com.CBR.service.serviceImpl;

import com.CBR.constain.StaticVariable;
import com.CBR.enity.Case;
import com.CBR.model.*;
import com.CBR.model.System;
import com.CBR.repository.CaseRepo;
import com.CBR.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    AnswerServiceImpl answerServiceImpl;

    @Autowired
    CaseRepo caseRepo;

    @Override
    public List<MotionSystem> getAllCaseChuyenDong() {
        List<MotionSystem> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Chuyển động");
        for(int i = 0; i < listAnswer.size(); i += 7){
            listCase.add(new MotionSystem(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3), listAnswer.get(i+4), listAnswer.get(i+5), listAnswer.get(i+6)));
        }
        return listCase;
    }

    @Override
    public List<PowerSystem> getAllCaseDien() {
        List<PowerSystem> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Điện");
        for(int i = 0; i < listAnswer.size(); i += 9){
            listCase.add(new PowerSystem(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3), listAnswer.get(i+4), listAnswer.get(i+5), listAnswer.get(i+6), listAnswer.get(i+7),listAnswer.get(i+8)));
        }
        return listCase;
    }

    @Override
    public List<EngineSystem> getAllCaseDongCo() {
        List<EngineSystem> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Động cơ");
        for(int i = 0; i < listAnswer.size(); i += 8){
            listCase.add(new EngineSystem(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3), listAnswer.get(i+4), listAnswer.get(i+5), listAnswer.get(i+6), listAnswer.get(i+7)));
        }
        return listCase;
    }

    @Override
    public List<System> getAllCaseKhiThai() {

        List<System> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Khí thải");
        for(int i = 0; i < listAnswer.size(); i += 4){
            listCase.add(new System(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3)));
        }
        return listCase;
    }

    @Override
    public List<System> getAllCaseTruyenLuc() {
        List<System> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Truyền lực");
        for(int i = 0; i < listAnswer.size(); i += 4){
            listCase.add(new System(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3)));
        }
        return listCase;
    }

    @Override
    public List<BrakeSystem> getAllCasePhanh() {
        List<BrakeSystem> listCase = new ArrayList<>();
        List<String> listAnswer = answerServiceImpl.getListAnswerInCaseByHeThong("Phanh");
        for(int i = 0; i < listAnswer.size(); i += 7){
            listCase.add(new BrakeSystem(listAnswer.get(i), listAnswer.get(i+1), listAnswer.get(i+2), listAnswer.get(i+3), listAnswer.get(i+4), listAnswer.get(i+5), listAnswer.get(i+6)));
        }
        return listCase;
    }
    @Override
    public void setAttributeCaseInputGeneral(String hangXe, String tenXe, String doiXe, String loiGapPhai) {
        StaticVariable.system.setHangXe(hangXe);
        StaticVariable.system.setTenXe(tenXe);
        StaticVariable.system.setDoiXe(doiXe);
        StaticVariable.system.setLoiGapPhai(loiGapPhai);
    }

    @Override
    public void setAttributeCaseSystemMotionInput(String oToKhiDiDuongPhang, String khungXeKhiQuaDuongNhapNho, String tinhTrangLop) {
        StaticVariable.chuyenDongForm.setHangXe(StaticVariable.system.getHangXe());
        StaticVariable.chuyenDongForm.setTenXe(StaticVariable.system.getTenXe());
        StaticVariable.chuyenDongForm.setDoiXe(StaticVariable.system.getDoiXe());
        StaticVariable.chuyenDongForm.setLoiGapPhai(StaticVariable.system.getLoiGapPhai());
        StaticVariable.chuyenDongForm.setTinhTrangLop(tinhTrangLop);
        StaticVariable.chuyenDongForm.setOToKhiDiDuongThang(oToKhiDiDuongPhang);
        StaticVariable.chuyenDongForm.setKhungXeKhiQuaDuongNhapNho(khungXeKhiQuaDuongNhapNho);
    }

    @Override
    public void setAttributeCaseBrakeSystemInput(String tuoiThoMaPhanh, String xeBiCanKhiThaPhanh, String mucDauPhanh) {
        StaticVariable.phanhForm.setHangXe(StaticVariable.system.getHangXe());
        StaticVariable.phanhForm.setTenXe(StaticVariable.system.getTenXe());
        StaticVariable.phanhForm.setDoiXe(StaticVariable.system.getDoiXe());
        StaticVariable.phanhForm.setLoiGapPhai(StaticVariable.system.getLoiGapPhai());
        StaticVariable.phanhForm.setTuoiThoMaPhanh(tuoiThoMaPhanh);
        StaticVariable.phanhForm.setXeBiCanKhiThaPhanh(xeBiCanKhiThaPhanh);
        StaticVariable.phanhForm.setMucDauPhanh(mucDauPhanh);
    }

    @Override
    public void setAttributeCaseEngineSystemInput(String tuoiThoAccquy, String tuoiThoBugi, String tiengDongLaTrongKhoangMay, String mucXangCuaBauPhao) {
        StaticVariable.dongCoForm.setHangXe(StaticVariable.system.getHangXe());
        StaticVariable.dongCoForm.setTenXe(StaticVariable.system.getTenXe());
        StaticVariable.dongCoForm.setDoiXe(StaticVariable.system.getDoiXe());
        StaticVariable.dongCoForm.setLoiGapPhai(StaticVariable.system.getLoiGapPhai());
        StaticVariable.dongCoForm.setTuoiThoAcquy(tuoiThoAccquy);
        StaticVariable.dongCoForm.setTuoiThoBugi(tuoiThoBugi);
        StaticVariable.dongCoForm.setTiengDongLaTrongKhoangMay(tiengDongLaTrongKhoangMay);
        StaticVariable.dongCoForm.setMucXangCuaBauPhao(mucXangCuaBauPhao);
    }

    @Override
    public void setAttributeCasePowerSystemInput(String tuoiThoAccquy, String tuoiThoMayPhatDien, String denPhaOto, String oCamCapDienKhong, String tiengKeuLaLucDeCuaOto) {
        StaticVariable.dienForm.setHangXe(StaticVariable.system.getHangXe());
        StaticVariable.dienForm.setTenXe(StaticVariable.system.getTenXe());
        StaticVariable.dienForm.setDoiXe(StaticVariable.system.getDoiXe());
        StaticVariable.dienForm.setLoiGapPhai(StaticVariable.system.getLoiGapPhai());
        StaticVariable.dienForm.setTuoiThoAccquy(tuoiThoAccquy);
        StaticVariable.dienForm.setTuoiThoMayPhatDien(tuoiThoMayPhatDien);
        StaticVariable.dienForm.setDenPhaOto(denPhaOto);
        StaticVariable.dienForm.setOCamCapDienKhong(oCamCapDienKhong);
        StaticVariable.dienForm.setTiengKeuLaLucDeCuaOto(tiengKeuLaLucDeCuaOto);
    }

    @Override
    public Case findCaseById(int id) {
        return caseRepo.findCaseById(id);
    }

}
