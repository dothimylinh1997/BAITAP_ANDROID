package com.example.studentmanage.Class;

import java.io.Serializable;

public class Lop implements Serializable {
    private String MaLop;
    private String TenLop;
    private String MaKhoa;

    public Lop(String maLop, String tenLop, String maKhoa) {
        MaLop = maLop;
        TenLop = tenLop;
        MaKhoa = maKhoa;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String tenLop) {
        TenLop = tenLop;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }
}
