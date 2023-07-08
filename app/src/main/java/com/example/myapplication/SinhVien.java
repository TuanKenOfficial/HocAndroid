package com.example.myapplication;

import androidx.annotation.NonNull;

public class SinhVien {
    private int ma;
    private String ten;


    public SinhVien() {
    }

    public SinhVien(int ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @NonNull
    @Override
    public String toString() {
        return this.ma+"-"+this.ten+"\n";
    }
}
