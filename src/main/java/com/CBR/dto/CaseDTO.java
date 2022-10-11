package com.CBR.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class CaseDTO {

    private String ansHangXe;
    private String ansTenXe;
    private String ansDoiXe;
    private String ansLoiGapPhai;
    private String ansHeThong;

}
