package com.example.myapplication.model;

import androidx.annotation.NonNull;

public class Music {
    private int ma;
    private String ten;
    private String casi;


    public Music() {
    }

    public Music(int ma, String ten, String casi) {
        this.ma = ma;
        this.ten = ten;
        this.casi = casi;
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

    public String getCasi() {
        return casi;
    }

    public void setCasi(String casi) {
        this.casi = casi;
    }

    @NonNull
    @Override
    public String toString() {
        return this.ma+"-"+this.ten+"\n"+this.casi;
    }
}
