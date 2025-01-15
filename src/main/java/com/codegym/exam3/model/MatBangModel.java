package com.codegym.exam3.model;

import java.time.LocalDate;

public class MatBangModel {
        private String maMatBang;
        private double dienTich;
        private String trangThai;
        private Integer tang;
        private String loaiVanPhong;
        private double giaTien;
        private LocalDate ngayBatDau;
        private LocalDate ngayKetThuc;

    public MatBangModel(String maMatBang, double dienTich, String trangThai, Integer tang, String loaiVanPhong, double giaTien, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.tang = tang;
        this.loaiVanPhong = loaiVanPhong;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Integer dienTich) {
        this.dienTich = dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public String getLoaiVanPhong() {
        return loaiVanPhong;
    }

    public void setLoaiVanPhong(String loaiVanPhong) {
        this.loaiVanPhong = loaiVanPhong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}

