package com.codegym.exam3.dao;

import com.codegym.exam3.connection.DBConnection;
import com.codegym.exam3.model.MatBangModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatBangDao {
    private static final String INSERT_MAT_BANG = "INSERT INTO matbang (maMatBang, dienTich, trangThai, tang, loaiVanPhong, giaTien, ngayBatDau, ngayKetThuc) " +
                                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_MAT_BANG = "SELECT * FROM matbang";
    private static final String DELETE_MAT_BANG = "DELETE FROM matbang WHERE maMatBang = ?";

    public void insertMatBang(MatBangModel matBang) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MAT_BANG)) {
            preparedStatement.setString(1, matBang.getMaMatBang());
            preparedStatement.setDouble(2, matBang.getDienTich());
            preparedStatement.setString(3, matBang.getTrangThai());
            preparedStatement.setInt(4, matBang.getTang());
            preparedStatement.setString(5, matBang.getLoaiVanPhong());
            preparedStatement.setDouble(6, matBang.getGiaTien());
            preparedStatement.setDate(7, Date.valueOf(matBang.getNgayBatDau()));
            preparedStatement.setDate(8, Date.valueOf(matBang.getNgayKetThuc()));

            preparedStatement.executeUpdate();
        }
    }

    public List<MatBangModel> selectAllMatBang() {
        List<MatBangModel> matBangList = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("maMatBang");
                Integer dienTich = resultSet.getInt("dienTich");
                String trangThai = resultSet.getString("trangThai");
                Integer tang = resultSet.getInt("tang");
                String loaiVanPhong = resultSet.getString("loaiVanPhong");
                Integer giaTien = resultSet.getInt("giaTien");
                Date ngayBatDau = resultSet.getDate("ngayBatDau");
                Date ngayKetThuc = resultSet.getDate("ngayKetThuc");
                MatBangModel matBang = new MatBangModel(maMatBang, dienTich, trangThai, tang, loaiVanPhong, giaTien, ngayBatDau.toLocalDate(), ngayKetThuc.toLocalDate());
                matBangList.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matBangList;
    }

    public void deleteMatBang(String maMatBang) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MAT_BANG)) {
            preparedStatement.setString(1, maMatBang);
            preparedStatement.executeUpdate();
        }
    }
}