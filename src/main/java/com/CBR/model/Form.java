package com.CBR.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Form {
//    SELECT ketluan.id, ketluan.nguyenhan, ketluan.suachua, ketluan.hethong, cautraloi.cautraloi
//    FROM cauhoi
//    JOIN cautraloi ON cauhoi.id = cautraloi.idcauhoi
//    JOIN motacase ON cautraloi.id = motacase.idcautraloi
//    JOIN ketluan ON motacase.idcase = ketluan.id
//    WHERE ketluan.hethong = "Phanh"

    private String hangXe;
    private String tenXe;
    private String doiXe;
    private String loiGapPhai;
    private String heThong;

}
