package com.example.studentmanage.Class;

import java.io.Serializable;

public class ThoiKhoaBieu implements Serializable {
    private String MaLop;
    private String MaMH;
    private String Thu;
    private String TietBD;
    private String PhongHoc;
    private String ThoiGian;

    public ThoiKhoaBieu(String maLop, String maMon, String thu, String tietBD, String phongHoc, String thoiGian){
        MaLop = maLop;
        MaMH = maMon;
        Thu = thu;
        TietBD = tietBD;
        PhongHoc = phongHoc;
        ThoiGian = thoiGian;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String maLop) {
        MaLop = maLop;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getThu() {
        return Thu;
    }

    public void setThu(String thu) {
        Thu = thu;
    }

    public String getTietBD() {
        return TietBD;
    }

    public void setTietBD(String tietBD) {
        TietBD = tietBD;
    }

    public String getPhongHoc() {
        return PhongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        PhongHoc = phongHoc;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(String thoiGian) {
        ThoiGian = thoiGian;
    }
}
