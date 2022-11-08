package com.CBR.model;

import lombok.*;

@Getter
@Setter
@ToString
public class PowerSystem extends System {

    private String tuoiThoAccquy;
    private String tuoiThoMayPhatDien;
    private String denPhaOto;
    private String oCamCapDienKhong;
    private String tiengKeuLaLucDeCuaOto;

    public PowerSystem() {
    }

    public PowerSystem(String hangXe, String tenXe, String doiXe, String loiGapPhai, String tuoiThoAccquy, String tuoiThoMayPhatDien, String denPhaOto, String oCamCapDienKhong, String tiengKeuLaLucDeCuaOto) {
        super(hangXe, tenXe, doiXe, loiGapPhai);
        this.tuoiThoAccquy = tuoiThoAccquy;
        this.tuoiThoMayPhatDien = tuoiThoMayPhatDien;
        this.denPhaOto = denPhaOto;
        this.oCamCapDienKhong = oCamCapDienKhong;
        this.tiengKeuLaLucDeCuaOto = tiengKeuLaLucDeCuaOto;
    }
}
