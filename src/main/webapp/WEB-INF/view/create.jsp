<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Tạo Mặt Bằng</title>
    <style>
        body {
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input, select, button {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        a {
            display: inline-block;
            margin-top: 10px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>Tạo Mặt Bằng Mới</h1>
<form action="/matbang" method="post">
    <label for="maMatBang">Mã mặt bằng:</label>
    <input type="text" id="maMatBang" name="maMatBang" required placeholder="Nhập mã mặt bằng"><br><br>

    <label for="dienTich">Diện tích (m²):</label>
    <input type="number" id="dienTich" name="dienTich" step="0.01" required placeholder="Nhập diện tích"><br><br>

    <label for="trangThai">Trạng thái:</label>
    <select id="trangThai" name="trangThai" required>
        <option value="Trống">Trống</option>
        <option value="Đầy đủ">Đầy đủ</option>
    </select><br><br>

    <label for="tang">Tầng:</label>
    <input type="number" id="tang" name="tang" required placeholder="Nhập tầng"><br><br>

    <label for="loaiVanPhong">Loại văn phòng:</label>
    <select id="loaiVanPhong" name="loaiVanPhong" required>
        <option value="Văn phòng chia sẻ">Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói">Văn phòng trọn gói</option>
    </select><br><br>

    <label for="giaTien">Giá cho thuê (VND):</label>
    <input type="number" id="giaTien" name="giaTien" required placeholder="Nhập giá cho thuê"><br><br>

    <label for="ngayBatDau">Ngày bắt đầu:</label>
    <input type="date" id="ngayBatDau" name="ngayBatDau" required><br><br>

    <label for="ngayKetThuc">Ngày kết thúc:</label>
    <input type="date" id="ngayKetThuc" name="ngayKetThuc" required><br><br>

    <button type="submit">Lưu</button>
    <a href="/matbang">Hủy</a>
</form>

</body>
</html>
