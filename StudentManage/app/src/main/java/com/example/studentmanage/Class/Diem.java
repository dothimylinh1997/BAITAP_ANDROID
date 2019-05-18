package com.example.studentmanage.Class;

public class Diem {
    private String MaMH;
    private String DiemCC;
    private String DiemKT;
    private String DiemCK;
    private String DiemTK;

    public Diem(String maMH, String diemCC, String diemKT, String diemCK, String diemTK) {
        MaMH = maMH;
        DiemCC = diemCC;
        DiemKT = diemKT;
        DiemCK = diemCK;
        DiemTK = diemTK;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public String getDiemCC() {
        return DiemCC;
    }

    public void setDiemCC(String diemCC) {
        DiemCC = diemCC;
    }

    public String getDiemKT() {
        return DiemKT;
    }

    public void setDiemKT(String diemKT) {
        DiemKT = diemKT;
    }

    public String getDiemCK() {
        return DiemCK;
    }

    public void setDiemCK(String diemCK) {
        DiemCK = diemCK;
    }

    public String getDiemTK() {
        return DiemTK;
    }

    public void setDiemTK(String diemTK) {
        DiemTK = diemTK;
    }
}
