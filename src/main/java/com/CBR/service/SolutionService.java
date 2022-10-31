package com.CBR.service;

import com.CBR.model.*;

public interface SolutionService {
    Solution findSolutionChuyenDong(ChuyenDongForm chuyenDongForm);
    Solution findSolutionPhanh(PhanhForm phanhForm);
    Solution findSolutionDongCo(DongCoForm dongCoForm);
    Solution findSolutionDien(DienForm dienForm);
    Solution findSolutionTruyenLucOrKhiThai(Form form, String heThong);


}
