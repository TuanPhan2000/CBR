package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class PhanhForm extends Form{

    private String tuoiThoMaPhanh;
    private String xeBiCanKhiThaPhanh;

    public PhanhForm() {
    }

    public PhanhForm(String hangXe, String tenXe, String doiXe, String loiGapPhai, String tuoiThoMaPhanh, String xeBiCanKhiThaPhanh, String mucDauPhanh) {
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
