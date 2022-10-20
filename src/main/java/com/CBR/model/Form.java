package com.CBR.model;

import lombok.*;

@Getter
@Setter
public class Form {

    private String hangXe;
    private String tenXe;
    private String doiXe;
    private String loiGapPhai;
    private String heThong;
    public Form() {
    }

    public Form(String hangXe, String tenXe, String doiXe, String loiGapPhai, String heThong) {
        this.hangXe = hangXe;
        this.tenXe = tenXe;
        this.doiXe = doiXe;
        this.loiGapPhai = loiGapPhai;
        this.heThong = heThong;
    }

    @Override
    public String toString() {
        return "hangXe='" + hangXe + '\'' +
                ", tenXe='" + tenXe + '\'' +
                ", doiXe='" + doiXe + '\'' +
                ", loiGapPhai='" + loiGapPhai + '\'' +
                ", heThong='" + heThong + '\'' +
                '}';
    }
}
