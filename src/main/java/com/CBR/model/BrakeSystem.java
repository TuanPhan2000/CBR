package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class BrakeSystem extends System {

    private String tuoiThoMaPhanh;
    private String xeBiCanKhiThaPhanh;

    public BrakeSystem() {
    }

    public BrakeSystem(String hangXe, String tenXe, String doiXe, String loiGapPhai, String tuoiThoMaPhanh, String xeBiCanKhiThaPhanh, String mucDauPhanh) {
        super(hangXe, tenXe, doiXe, loiGapPhai);
        this.tuoiThoMaPhanh = tuoiThoMaPhanh;
        this.xeBiCanKhiThaPhanh = xeBiCanKhiThaPhanh;
        this.mucDauPhanh = mucDauPhanh;
    }

    @Override
    public String toString() {
        return "PhanhForm{" + super.toString() +
                "tuoiThoMaPhanh='" + tuoiThoMaPhanh + '\'' +
                ", xeBiCanKhiThaPhanh='" + xeBiCanKhiThaPhanh + '\'' +
                ", mucDauPhanh='" + mucDauPhanh + '\'' +
                '}';
    }

    private String mucDauPhanh;

}
