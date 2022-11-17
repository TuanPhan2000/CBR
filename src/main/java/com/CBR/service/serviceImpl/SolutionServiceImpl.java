package com.CBR.service.serviceImpl;

import com.CBR.enity.Case;
import com.CBR.enity.CaseDescription;
import com.CBR.model.*;
import com.CBR.model.System;
import com.CBR.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    CaseServiceImpl caseServiceImpl;
    @Autowired
    AnswerServiceImpl answerServiceImpl;
    @Autowired
    CaseDescriptionServiceImpl caseDescriptionServiceImpl;


    private int soSanhThuocTinh(String caseHT, String caseInput){
        return caseHT.equals(caseInput) ? 1 : 0;
    }

    @Override
    public Solution findSolutionChuyenDong(MotionSystem chuyenDongForm) {

        List<MotionSystem> listCase = caseServiceImpl.getAllCaseChuyenDong();
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = (soSanhThuocTinh(listCase.get(i).getHangXe(), chuyenDongForm.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                                soSanhThuocTinh(listCase.get(i).getTenXe(), chuyenDongForm.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), chuyenDongForm.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), chuyenDongForm.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                    soSanhThuocTinh(listCase.get(i).getOToKhiDiDuongThang(), chuyenDongForm.getOToKhiDiDuongThang()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getOToKhiDiDuongThang()) +
                    soSanhThuocTinh(listCase.get(i).getKhungXeKhiQuaDuongNhapNho(), chuyenDongForm.getKhungXeKhiQuaDuongNhapNho()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getKhungXeKhiQuaDuongNhapNho()) +
                    soSanhThuocTinh(listCase.get(i).getTinhTrangLop(), chuyenDongForm.getTinhTrangLop()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTinhTrangLop())) /
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                             answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getOToKhiDiDuongThang()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getKhungXeKhiQuaDuongNhapNho()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTinhTrangLop()));

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        MotionSystem f = listCase.get(viTri);

        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList2){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList3){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList4){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList5 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTinhTrangLop()).getId());
        for(CaseDescription caseDescription : caseDescriptionList5){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList6 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getKhungXeKhiQuaDuongNhapNho()).getId());
        for(CaseDescription caseDescription : caseDescriptionList6){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList7 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getOToKhiDiDuongThang()).getId());
        for(CaseDescription caseDescription : caseDescriptionList7){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        int idCaseResult = 0;
        int max = 0;
        for(int i = 1; i <= 64; i++){
            if(max < listIdCase[i]){
                max = listIdCase[i];
                idCaseResult = i;
            }
        }
        Case c = caseServiceImpl.findCaseById(idCaseResult);
        Solution s = new Solution();
        s.setCachSuaChua(c.getSuaChua());
        s.setNguyenNhan(c.getNguyenNhan());
        s.setDoChinhXac(doTuongDongMax*100);
        return s;
    }

    @Override
    public Solution findSolutionPhanh(BrakeSystem phanhForm) {
        List<BrakeSystem> listCase = caseServiceImpl.getAllCasePhanh();
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = (soSanhThuocTinh(listCase.get(i).getHangXe(), phanhForm.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                    soSanhThuocTinh(listCase.get(i).getTenXe(), phanhForm.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), phanhForm.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), phanhForm.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                    soSanhThuocTinh(listCase.get(i).getTuoiThoMaPhanh(), phanhForm.getTuoiThoMaPhanh()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoMaPhanh()) +
                    soSanhThuocTinh(listCase.get(i).getXeBiCanKhiThaPhanh(), phanhForm.getXeBiCanKhiThaPhanh()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getXeBiCanKhiThaPhanh()) +
                    soSanhThuocTinh(listCase.get(i).getMucDauPhanh(), phanhForm.getMucDauPhanh()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getMucDauPhanh())) /
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoMaPhanh()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getXeBiCanKhiThaPhanh()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getMucDauPhanh()));

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        BrakeSystem f = listCase.get(viTri);

        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList2){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList3){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList4){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList5 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTuoiThoMaPhanh()).getId());
        for(CaseDescription caseDescription : caseDescriptionList5){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList6 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getXeBiCanKhiThaPhanh()).getId());
        for(CaseDescription caseDescription : caseDescriptionList6){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList7 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getMucDauPhanh()).getId());
        for(CaseDescription caseDescription : caseDescriptionList7){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        int idCaseResult = 0;
        int max = 0;
        for(int i = 1; i <= 64; i++){
            if(max < listIdCase[i]){
                max = listIdCase[i];
                idCaseResult = i;
            }
        }
        Case c = caseServiceImpl.findCaseById(idCaseResult);
        Solution s = new Solution();
        s.setCachSuaChua(c.getSuaChua());
        s.setNguyenNhan(c.getNguyenNhan());
        s.setDoChinhXac(doTuongDongMax*100);
        return s;
    }

    @Override
    public Solution findSolutionDongCo(EngineSystem dongCoForm) {
        List<EngineSystem> listCase = caseServiceImpl.getAllCaseDongCo();
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = (soSanhThuocTinh(listCase.get(i).getHangXe(), dongCoForm.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                    soSanhThuocTinh(listCase.get(i).getTenXe(), dongCoForm.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), dongCoForm.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), dongCoForm.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                    soSanhThuocTinh(listCase.get(i).getTuoiThoAcquy(), dongCoForm.getTuoiThoAcquy()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoAcquy()) +
                    soSanhThuocTinh(listCase.get(i).getTuoiThoBugi(), dongCoForm.getTuoiThoBugi()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoBugi()) +
                    soSanhThuocTinh(listCase.get(i).getTiengDongLaTrongKhoangMay(), dongCoForm.getTiengDongLaTrongKhoangMay()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTiengDongLaTrongKhoangMay()) +
                    soSanhThuocTinh(listCase.get(i).getMucXangCuaBauPhao(), dongCoForm.getMucXangCuaBauPhao()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getMucXangCuaBauPhao())) /
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoAcquy()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoBugi()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTiengDongLaTrongKhoangMay()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getMucXangCuaBauPhao()));

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        EngineSystem f = listCase.get(viTri);

        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList2){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList3){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList4){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList5 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTuoiThoAcquy()).getId());
        for(CaseDescription caseDescription : caseDescriptionList5){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList6 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTuoiThoBugi()).getId());
        for(CaseDescription caseDescription : caseDescriptionList6){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList7 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTiengDongLaTrongKhoangMay()).getId());
        for(CaseDescription caseDescription : caseDescriptionList7){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList8 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getMucXangCuaBauPhao()).getId());
        for(CaseDescription caseDescription : caseDescriptionList8){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        int idCaseResult = 0;
        int max = 0;
        for(int i = 1; i <= 64; i++){
            if(max < listIdCase[i]){
                max = listIdCase[i];
                idCaseResult = i;
            }
        }
        Case c = caseServiceImpl.findCaseById(idCaseResult);
        Solution s = new Solution();
        s.setCachSuaChua(c.getSuaChua());
        s.setNguyenNhan(c.getNguyenNhan());
        s.setDoChinhXac(doTuongDongMax*100);
        return s;
    }

    @Override
    public Solution findSolutionDien(PowerSystem dienForm) {
        List<PowerSystem> listCase = caseServiceImpl.getAllCaseDien();
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = (soSanhThuocTinh(listCase.get(i).getHangXe(), dienForm.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                    soSanhThuocTinh(listCase.get(i).getTenXe(), dienForm.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), dienForm.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), dienForm.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                    soSanhThuocTinh(listCase.get(i).getTuoiThoAccquy(), dienForm.getTuoiThoAccquy()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoAccquy()) +
                    soSanhThuocTinh(listCase.get(i).getTuoiThoMayPhatDien(), dienForm.getTuoiThoMayPhatDien()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoMayPhatDien()) +
                    soSanhThuocTinh(listCase.get(i).getDenPhaOto(), dienForm.getDenPhaOto()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDenPhaOto()) +
                    soSanhThuocTinh(listCase.get(i).getOCamCapDienKhong(), dienForm.getOCamCapDienKhong()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getOCamCapDienKhong()) +
                    soSanhThuocTinh(listCase.get(i).getTiengKeuLaLucDeCuaOto(), dienForm.getTiengKeuLaLucDeCuaOto()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTiengKeuLaLucDeCuaOto())) /
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoAccquy()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTuoiThoMayPhatDien()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDenPhaOto()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getOCamCapDienKhong()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTiengKeuLaLucDeCuaOto()) );

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        PowerSystem f = listCase.get(viTri);

        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList2){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList3){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList4){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList5 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTuoiThoAccquy()).getId());
        for(CaseDescription caseDescription : caseDescriptionList5){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList6 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTuoiThoMayPhatDien()).getId());
        for(CaseDescription caseDescription : caseDescriptionList6){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList7 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDenPhaOto()).getId());
        for(CaseDescription caseDescription : caseDescriptionList7){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList8 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getOCamCapDienKhong()).getId());
        for(CaseDescription caseDescription : caseDescriptionList8){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList9 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTiengKeuLaLucDeCuaOto()).getId());
        for(CaseDescription caseDescription : caseDescriptionList9){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        int idCaseResult = 0;
        int max = 0;
        for(int i = 1; i <= 64; i++){
            if(max < listIdCase[i]){
                max = listIdCase[i];
                idCaseResult = i;
            }
        }
        Case c = caseServiceImpl.findCaseById(idCaseResult);
        Solution s = new Solution();
        s.setCachSuaChua(c.getSuaChua());
        s.setNguyenNhan(c.getNguyenNhan());
        s.setDoChinhXac(doTuongDongMax*100);
        return s;
    }

    @Override
    public Solution findSolutionTruyenLucOrKhiThai(System system, String heThong) {
        List<System> listCase = new ArrayList<>();
        if(heThong.equals("Truyền lực")){
            listCase = caseServiceImpl.getAllCaseTruyenLuc();
        }
        else {
            listCase = caseServiceImpl.getAllCaseKhiThai();
        }
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = ((soSanhThuocTinh(listCase.get(i).getHangXe(), system.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                    soSanhThuocTinh(listCase.get(i).getTenXe(), system.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), system.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), system.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai()))/
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai())));

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        System f = listCase.get(viTri);
        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList2){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList3){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList4){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        int idCaseResult = 0;
        int max = 0;
        for(int i = 1; i <= 64; i++){
            if(max < listIdCase[i]){
                max = listIdCase[i];
                idCaseResult = i;
            }
        }
        Case c = caseServiceImpl.findCaseById(idCaseResult);
        Solution s = new Solution();
        s.setCachSuaChua(c.getSuaChua());
        s.setNguyenNhan(c.getNguyenNhan());
        s.setDoChinhXac(doTuongDongMax*100);
        return s;
    }

}
