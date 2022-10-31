package com.CBR.service.serviceImpl;

import com.CBR.enity.Case;
import com.CBR.enity.CaseDescription;
import com.CBR.model.*;
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
    public Solution findSolutionChuyenDong(ChuyenDongForm chuyenDongForm) {

        List<ChuyenDongForm> listCase = caseServiceImpl.getAllCaseChuyenDong();
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
        return null;
    }

    @Override
    public Solution findSolutionPhanh(PhanhForm phanhForm) {
        return null;
    }

    @Override
    public Solution findSolutionDongCo(DongCoForm dongCoForm) {
        return null;
    }

    @Override
    public Solution findSolutionDien(DienForm dienForm) {
        return null;
    }

    @Override
    public Solution findSolutionTruyenLucOrKhiThai(Form form, String heThong) {
        List<Form> listCase = new ArrayList<>();
        if(heThong.equals("Truyền lực")){
            listCase = caseServiceImpl.getAllCaseTruyenLuc();
        }
        else {
            listCase = caseServiceImpl.getAllCaseKhiThai();
        }
        float doTuongDongMax = 0;
        int viTri = 0;
        for(int i = 0; i < listCase.size(); i++){
            float doTuongDong = (soSanhThuocTinh(listCase.get(i).getHangXe(), form.getHangXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                    soSanhThuocTinh(listCase.get(i).getTenXe(), form.getTenXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                    soSanhThuocTinh(listCase.get(i).getDoiXe(), form.getDoiXe()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                    soSanhThuocTinh(listCase.get(i).getLoiGapPhai(), form.getLoiGapPhai()) * answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai())/
                    (float) (answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getHangXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getTenXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getDoiXe()) +
                            answerServiceImpl.getTrongSoByAnswer(listCase.get(i).getLoiGapPhai())));

            if(doTuongDong > doTuongDongMax) {
                doTuongDongMax = doTuongDong;
                viTri = i;
            }

        }
        Form f = listCase.get(viTri);
        int[] listIdCase = new int[65];
        for(int i = 0; i <= 64; i++ ){
            listIdCase[i] = 0;
        }
        List<CaseDescription> caseDescriptionList1 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getHangXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList2 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getTenXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList3 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getDoiXe()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
            listIdCase[caseDescription.getCase1().getId()]++;
        }
        List<CaseDescription> caseDescriptionList4 = caseDescriptionServiceImpl.findCaseDescriptionsByIdAnswer(answerServiceImpl.findAnswerByCauTraLoi(f.getLoiGapPhai()).getId());
        for(CaseDescription caseDescription : caseDescriptionList1){
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
