package model;

import java.io.Serializable;

public class Sach implements Serializable {
    private String masach;
    private String tensach;
    private String phanLoai;
    private String gia;
    private String tacgia;
    private String nhaxuatban;
    private int hinhanh;

    public Sach(String masach, String tensach, String phanLoai, String gia, String tacgia, int hinhanh) {
        this.masach = masach;
        this.tensach = tensach;
        this.phanLoai = phanLoai;
        this.gia = gia;
        this.tacgia = tacgia;
        this.nhaxuatban = nhaxuatban;
        this.hinhanh = hinhanh;
    }
    public Sach(){

    }
    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public String getNhaxuatban() {
        return nhaxuatban;
    }

    public void setNhaxuatban(String nhaxuatban) {
        this.nhaxuatban = nhaxuatban;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}
