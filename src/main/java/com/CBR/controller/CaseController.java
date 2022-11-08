package com.CBR.controller;


import com.CBR.constain.StaticVariable;
import com.CBR.model.Solution;
import com.CBR.service.serviceImpl.CaseServiceImpl;
import com.CBR.service.serviceImpl.SolutionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CaseController {

    @Autowired
    SolutionServiceImpl solutionServiceImpl;

    @Autowired
    CaseServiceImpl caseServiceImpl;

    @PostMapping("/submitDetailInfor/chuyenDong")
    public String getSolutionMotionSystem(Model model,
                                          @RequestParam("Ô tô khi đi đường phẳng") String oToKhiDiDuongPhang,
                                          @RequestParam("Khung xe khi qua đường nhấp nhô") String khungXeKhiQuaDuongNhapNho,
                                          @RequestParam("Tình trạng lốp") String tinhTrangLop){
        caseServiceImpl.setAttributeCaseSystemMotionInput(oToKhiDiDuongPhang, khungXeKhiQuaDuongNhapNho, tinhTrangLop);
        Solution s = solutionServiceImpl.findSolutionChuyenDong(StaticVariable.chuyenDongForm);
        model.addAttribute("solution", s);
        return "index";
    }

    @PostMapping("/submitDetailInfor/phanh")
    public String getSolutionBrakeSystem(Model model,
                                          @RequestParam("Tuổi thọ má phanh") String tuoiThoMaPhanh,
                                          @RequestParam("Xe bị cản khi thả phanh") String xeBiCanKhiThaPhanh,
                                          @RequestParam("Mức dầu phanh") String mucDauPhanh){
        caseServiceImpl.setAttributeCaseBrakeSystemInput(tuoiThoMaPhanh, xeBiCanKhiThaPhanh, mucDauPhanh);
        Solution s = solutionServiceImpl.findSolutionPhanh(StaticVariable.phanhForm);
        model.addAttribute("solution", s);
        return "index";
    }
    @PostMapping("/submitDetailInfor/dongCo")
    public String getSolutionBrakeSystem(Model model,
                                         @RequestParam("Tuổi thọ acquy") String tuoiThoAccquy,
                                         @RequestParam("Tuổi thọ bugi") String tuoiThoBugi,
                                         @RequestParam("Tiếng động lạ trong khoang máy") String tiengDongLaTrongKhoangMay,
                                         @RequestParam("Mức xăng của bầu phao") String mucXangCuaBauPhao){
        caseServiceImpl.setAttributeCaseEngineSystemInput(tuoiThoAccquy, tuoiThoBugi, tiengDongLaTrongKhoangMay, mucXangCuaBauPhao);
        Solution s = solutionServiceImpl.findSolutionDongCo(StaticVariable.dongCoForm);
        model.addAttribute("solution", s);
        return "index";
    }
    @PostMapping("/submitDetailInfor/dien")
    public String getSolutionPowerSystem(Model model,
                                         @RequestParam("Tuổi thọ acquy") String tuoiThoAccquy,
                                         @RequestParam("Tuổi thọ máy phát điện") String tuoiThoMayPhatDien,
                                         @RequestParam("Đèn pha ô tô") String denPhaOto,
                                         @RequestParam("Ổ cắm cấp điện không") String oCamCapDienKhong,
                                         @RequestParam("Tiếng kêu lạ lúc đề của ô tô") String tiengKeuLaLucDeCuaOto){
        caseServiceImpl.setAttributeCasePowerSystemInput(tuoiThoAccquy, tuoiThoMayPhatDien, denPhaOto, oCamCapDienKhong, tiengKeuLaLucDeCuaOto);
        Solution s = solutionServiceImpl.findSolutionDien(StaticVariable.dienForm);
        model.addAttribute("solution", s);
        return "index";
    }
}
