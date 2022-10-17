package com.CBR.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongCoForm extends Form{

    private String tuoiThoAcquy;
    private String tuoiThoBugi;
    private String tiengDongLaTrongKhoangMay;
    private String mucXangCuaBauPhao;

}
