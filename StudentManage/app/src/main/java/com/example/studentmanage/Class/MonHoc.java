package com.example.studentmanage.Class;

import java.io.Serializable;

public class MonHoc implements Serializable {
    private String MaMH;
    private String TenMH;


    public MonHoc(String maMH, String tenMH) {
        MaMH = maMH;
        TenMH = tenMH;

    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }


}

