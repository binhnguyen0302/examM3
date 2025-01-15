package com.codegym.exam3.controller;


import com.codegym.exam3.dao.MatBangDao;
import com.codegym.exam3.model.MatBangModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "matbang", urlPatterns = {"/create", "/matbang"})
public class MatBangController extends HttpServlet {
    private MatBangDao matBangDao = new MatBangDao();

    @Override
    public void init() {
        matBangDao = new MatBangDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        if (action == null) action = "";
        try {
            switch (action) {
                case "/create":
                    showCreateForm(request, response);
                    break;
                case "/":
                    showCreateForm(request, response);
                    break;
                case "/matbang":
                    ListMatBang(request, response);
                    break;
                default:
                    ListMatBang(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
    }

    private void createMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String maMatBang = request.getParameter("maMatBang");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        String trangThai = request.getParameter("trangThai");
        Integer tang = Integer.parseInt(request.getParameter("tang"));
        String loaiVanPhong = request.getParameter("loaiVanPhong");
        Integer giaTien = Integer.parseInt(request.getParameter("giaTien"));
        LocalDate ngayBatDau = LocalDate.parse(request.getParameter("ngayBatDau"));
        LocalDate ngayKetThuc = LocalDate.parse(request.getParameter("ngayKetThuc"));
        matBangDao.insertMatBang(new MatBangModel(maMatBang, dienTich, trangThai, tang, loaiVanPhong, giaTien, ngayBatDau, ngayKetThuc));
        response.sendRedirect("/matbang");
    }

    private void ListMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBangModel> matBangList = matBangDao.selectAllMatBang();
        request.setAttribute("matBangList", matBangDao.selectAllMatBang());
        request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            createMatBang(request, response);
        } catch (SQLException e) {
            e.printStackTrace();

            request.setAttribute("errorMessage", "Có lỗi xảy ra khi lưu dữ liệu!");
            request.getRequestDispatcher("/WEB-INF/view/create.jsp").forward(request, response);
        }
    }

}

