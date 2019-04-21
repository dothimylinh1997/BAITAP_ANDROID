package com.example.myapplication;

public class MonHoc {
    String maMH;
    String tenMH;
    int sotiet;

    public MonHoc() {
    }

    public MonHoc(String tenMH, int sotiet ) {
        this.tenMH = tenMH;
        this.sotiet = sotiet;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH( String maMH ) {
        this.maMH = maMH;
    }

    public String getTenMH() {
        return tenMH;
    }

    public void setTenMH( String tenMH ) {
        this.tenMH = tenMH;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setSotiet( int sotiet ) {
        this.sotiet = sotiet;
    }
}


