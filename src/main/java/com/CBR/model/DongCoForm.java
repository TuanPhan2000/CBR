package com.CBR.model;

import lombok.*;

@Getter
@Setter
@ToString
public class DongCoForm extends Form{

    private String tuoiThoAcquy;
    private String tuoiThoBugi;
    private String tiengDongLaTrongKhoangMay;
    private String mucXangCuaBauPhao;

    public DongCoForm() {
    }

    public DongCoForm(String hangXe, String tenXe, String doiXe, String loiGapPhai, String tuoiThoAcquy, String tuoiThoBugi, String tiengDongLaTrongKhoangMay, String mucXangCuaBauPhao) {
        super(hangXe, tenXe, doiXe, loiGapPhai);
        this.tuoiThoAcquy = tuoiThoAcquy;
        this.tuoiThoBugi = tuoiThoBugi;
        this.tiengDongLaTrongKhoangMay = tiengDongLaTrongKhoangMay;
        this.mucXangCuaBauPhao = mucXangCuaBauPhao;
    }
}
