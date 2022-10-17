package com.CBR.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChuyenDongForm extends Form{

    private String oToKhiDiDuongThang;
    private String khungXeKhiQuaDuongNhapNho;
    private String tinhTrangLop;

}
