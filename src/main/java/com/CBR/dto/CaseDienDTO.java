package com.CBR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CaseDienDTO extends CaseDTO {

    private String ansXeKhoNoKhiDe;
    private String ansTuoiThoAcquy;
    private String ansTuoiThoMayPhatDien;
    private String ansTrieuChungCuaDenPhaOto;
    private String ansOCamCapDienKhong;
    private String ansTiengKeuLaLucDeCuaOto;

}
