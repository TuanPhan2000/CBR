package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class MotionSystem extends System {

    private String oToKhiDiDuongThang;
    private String khungXeKhiQuaDuongNhapNho;
    private String tinhTrangLop;

    public MotionSystem() {
    }

    public MotionSystem(String hangXe, String tenXe, String doiXe, String loiGapPhai, String oToKhiDiDuongThang, String khungXeKhiQuaDuongNhapNho, String tinhTrangLop) {
        super(hangXe, tenXe, doiXe, loiGapPhai);
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
