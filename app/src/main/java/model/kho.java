package model;

import java.util.ArrayList;

public class kho {
    private String Phanloai;
    private String mota;

    public kho(String phanloai, String mota, int hinhanh) {
        Phanloai = phanloai;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }

    private int hinhanh;
    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public ArrayList<Sach> getDs() {
        return ds;
    }

    public void setDs(ArrayList<Sach> ds) {
        this.ds = ds;
    }

    private ArrayList<Sach> ds=new ArrayList<Sach>();



    public String getPhanloai() {
        return Phanloai;
    }

    public void setPhanloai(String phanloai) {
        Phanloai = phanloai;
    }




}
