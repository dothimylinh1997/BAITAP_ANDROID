package com.example.managestudent;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String MaSv;
    private String HoTen;
    private String NgaySinh;
    private String DiaChi;
    private String GioiTinh;
    private String MaLop;

    public SinhVien(String maSV, String hoTen, String ngaySinh, String diaChi, String maLop, String gioiTinh) {
        MaSv = maSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        MaLop = maLop;
        GioiTinh = gioiTinh;

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

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

}
