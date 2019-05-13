package com.example.studentmanage.Class;

import java.io.Serializable;

public class Khoa implements Serializable {
    private String MaKhoa;
    private String TenKhoa;

    public Khoa(String maKhoa, String tenKhoa) {
        MaKhoa = maKhoa;
        TenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return MaKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        MaKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        TenKhoa = tenKhoa;
    }


}
