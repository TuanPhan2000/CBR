package com.CBR.model;


import lombok.*;

@Getter
@Setter
@ToString
public class Solution {

    private String nguyenNhan;
    private String cachSuaChua;
    private float doChinhXac;

    public Solution() {
    }

    public Solution(String nguyenNhan, String cachSuaChua, float doChinhXac) {
        this.nguyenNhan = nguyenNhan;
        this.cachSuaChua = cachSuaChua;
        this.doChinhXac = doChinhXac;
    }
}
