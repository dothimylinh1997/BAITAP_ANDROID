package com.example.studentmanage.Class;

public class SinhVienDiemDanh {
    private String MaSv;
    private String MaMh;
    private String Ngay;
    private String DiemDanh;

    public SinhVienDiemDanh(String maSv, String maMh, String ngay, String diemDanh) {
        MaSv = maSv;
        MaMh = maMh;
        Ngay = ngay;
        DiemDanh = diemDanh;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getMaMh() {
        return MaMh;
    }

    public void setMaMh(String maMh) {
        MaMh = maMh;
    }

    public String getNgay() {
        return Ngay;
    }

    public void setNgay(String ngay) {
        Ngay = ngay;
    }

    public String getDiemDanh() {
        return DiemDanh;
    }

    public void setDiemDanh(String diemDanh) {
        DiemDanh = diemDanh;
    }
}
