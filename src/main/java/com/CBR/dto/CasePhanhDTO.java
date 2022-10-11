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
public class CasePhanhDTO extends CaseDTO {

    private String ansTuoiThoMaPhanh;
    private String ansXeBiCanKhiThaPhanh;
    private String ansMucDauPhanh;

}
