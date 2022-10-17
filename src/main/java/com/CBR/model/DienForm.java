package com.CBR.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DienForm extends Form{

    private String xeKhoNoKhiDe;
    private String tuoiThoAcquy;
    private String tuoiThoMayPhatDien;

}
