package com.example.studentmanage.Class;

import java.io.Serializable;

public class BangDiem implements Serializable {
    private String HoTen;
    private String DiemCC;
    private String DiemTH;
    private String DiemGK;
    private String DiemCK;

    public BangDiem(String hoTen, String diemCC, String diemTH, String diemGK, String diemCK) {
        HoTen = hoTen;
        DiemCC = diemCC;
        DiemTH = diemTH;
        DiemGK = diemGK;
        DiemCK = diemCK;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getDiemCC() {
        return DiemCC;
    }

    public void setDiemCC(String diemCC) {
        DiemCC = diemCC;
    }

    public String getDiemTH() {
        return DiemTH;
    }

    public void setDiemTH(String diemTH) {
        DiemTH = diemTH;
    }

    public String getDiemGK() {
        return DiemGK;
    }

    public void setDiemGK(String diemGK) {
        DiemGK = diemGK;
    }

    public String getDiemCK() {
        return DiemCK;
    }

    public void setDiemCK(String diemCK) {
        DiemCK = diemCK;
    }
}
