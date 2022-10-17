package com.CBR.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhanhForm extends Form{

    private String tuoiThoMaPhanh;
    private String xeBiCanKhiThaPhanh;
    private String mucDauPhanh;

}
