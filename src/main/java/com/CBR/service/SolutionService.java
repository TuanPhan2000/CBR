package com.CBR.service;

import com.CBR.model.*;
import com.CBR.model.System;

public interface SolutionService {
    Solution findSolutionChuyenDong(MotionSystem chuyenDongForm);
    Solution findSolutionPhanh(BrakeSystem phanhForm);
    Solution findSolutionDongCo(EngineSystem dongCoForm);
    Solution findSolutionDien(PowerSystem dienForm);
    Solution findSolutionTruyenLucOrKhiThai(System system, String heThong);


}
