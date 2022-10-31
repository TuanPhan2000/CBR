package com.CBR.service.serviceImpl;

import com.CBR.model.ChuyenDongForm;
import com.CBR.model.Form;
import com.CBR.model.Solution;
import com.CBR.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Autowired
    CaseServiceImpl caseServiceImpl;
    @Autowired
    AnswerServiceImpl answerServiceImpl;

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

}
