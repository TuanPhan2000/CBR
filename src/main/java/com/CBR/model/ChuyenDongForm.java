package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class ChuyenDongForm extends Form{

    private String oToKhiDiDuongThang;
    private String khungXeKhiQuaDuongNhapNho;
    private String tinhTrangLop;


    public ChuyenDongForm(String hangXe, String tenXe, String doiXe, String loiGapPhai, String heThong, String oToKhiDiDuongThang, String khungXeKhiQuaDuongNhapNho, String tinhTrangLop) {
        super(hangXe, tenXe, doiXe, loiGapPhai, heThong);
        this.oToKhiDiDuongThang = oToKhiDiDuongThang;
        this.khungXeKhiQuaDuongNhapNho = khungXeKhiQuaDuongNhapNho;
        this.tinhTrangLop = tinhTrangLop;
    }

    @Override
    public String toString() {
        return "ChuyenDongForm{" + super.toString() +
                "oToKhiDiDuongThang='" + oToKhiDiDuongThang + '\'' +
                ", khungXeKhiQuaDuongNhapNho='" + khungXeKhiQuaDuongNhapNho + '\'' +
                ", tinhTrangLop='" + tinhTrangLop + '\'' +
                '}';
    }
}
