package com.example.studentmanage.Class;

public class SinhVienXemDiemDanh {
    private String MaSv;
    private String MaMH;
    private String Ngay;
    private String DiemDanh;
    private String HoTen;

    public SinhVienXemDiemDanh(String maSv, String maMH, String ngay, String diemDanh, String hoTen) {
        MaSv = maSv;
        MaMH = maMH;
        Ngay = ngay;
        DiemDanh = diemDanh;
        HoTen = hoTen;
    }

    public String getMaSv() {
        return MaSv;
    }

    public void setMaSv(String maSv) {
        MaSv = maSv;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
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

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }
}
