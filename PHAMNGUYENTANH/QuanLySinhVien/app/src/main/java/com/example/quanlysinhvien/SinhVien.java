package com.example.quanlysinhvien;

public class SinhVien {
    private int MaSV;
    private String HoTen;
    private  int NgaySinh;
    private String DiaChi;
    private  int GioiTinh;
    private  int MaLop;

    public SinhVien(int maSV, String hoTen, int ngaySinh, String diaChi, int gioiTinh, int maLop) {
        MaSV = maSV;
        HoTen = hoTen;
        NgaySinh = ngaySinh;
        DiaChi = diaChi;
        GioiTinh = gioiTinh;
        MaLop = maLop;
    }

    public int getMaSV() {
        return MaSV;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public int getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(int ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int maLop) {
        MaLop = maLop;
    }
}