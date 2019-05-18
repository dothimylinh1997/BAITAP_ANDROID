package com.example.studentmanage.Class;

import java.io.Serializable;

public class DsSinhVien implements Serializable {
    private String MaSv;
    private String HoTen;
    private String MaMH;

    public DsSinhVien(String maSv, String hoTen, String maMH) {
        MaSv = maSv;
        HoTen = hoTen;
        MaMH = maMH;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }
}
