package com.example.myapplication.model;

import androidx.annotation.NonNull;

public class Contact {
    private int ma;
    private String ten;
    private String gioitinh;
    private String diachi;
    private String phone;

    public Contact() {
    }

    public Contact(int ma, String ten, String gioitinh, String diachi, String phone) {
        this.ma = ma;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.phone = phone;
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

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @NonNull
    @Override
    public String toString() {
        return this.ma+"-"+this.ten+"\n"+this.gioitinh+"-"+this.diachi+"\n"+this.phone;
    }
}
