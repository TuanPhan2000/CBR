package com.CBR.model;

import lombok.*;

@Getter
@Setter
@ToString
public class DienForm extends Form{

    private String tuoiThoAccquy;
    private String tuoiThoMayPhatDien;
    private String denPhaOto;
    private String oCamCapDienKhong;
    private String tiengKeuLaLucDeCuaOto;

    public DienForm() {
    }

    public DienForm(String hangXe, String tenXe, String doiXe, String loiGapPhai, String tuoiThoAccquy, String tuoiThoMayPhatDien, String denPhaOto, String oCamCapDienKhong, String tiengKeuLaLucDeCuaOto) {
        super(hangXe, tenXe, doiXe, loiGapPhai);
        this.tuoiThoAccquy = tuoiThoAccquy;
        this.tuoiThoMayPhatDien = tuoiThoMayPhatDien;
        this.denPhaOto = denPhaOto;
        this.oCamCapDienKhong = oCamCapDienKhong;
        this.tiengKeuLaLucDeCuaOto = tiengKeuLaLucDeCuaOto;
    }
}
