package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class PhanhForm extends Form{

    private String tuoiThoMaPhanh;
    private String xeBiCanKhiThaPhanh;

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
