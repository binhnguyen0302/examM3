<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh Sách Mặt Bằng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        h1 {
            color: #333;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        button {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
        }

        button:hover {
            background-color: #45a049;
        }

        form {
            margin-bottom: 20px;
        }

        label {
            margin-right: 10px;
        }

        input, select {
            padding: 8px;
            margin: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .message {
            padding: 10px;
            margin-top: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        .success {
            color: green;
        }

        .error {
            color: red;
        }
    </style>
</head>
<body>
<h1>Danh Sách Mặt Bằng</h1>
<a href="/create">Thêm Mặt Bằng</a><br><br>

<c:if test="${not empty message}">
    <div class="message ${messageType}">
            ${message}
    </div>
</c:if>

<form action="/matbang" method="get">
    <label for="loaiVanPhong">Loại văn phòng:</label>
    <select id="loaiVanPhong" name="loaiVanPhong">
        <option value="">Tất cả</option>
        <option value="Văn phòng chia sẻ">Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói">Văn phòng trọn gói</option>
    </select>

    <label for="giaTien">Giá tiền:</label>
    <input type="number" id="giaTien" name="giaTien">

    <label for="tang">Tầng:</label>
    <input type="number" id="tang" name="tang">

    <button type="submit">Tìm kiếm</button>
</form>

<table>
    <thead>
    <tr>
        <th>Mã mặt bằng</th>
        <th>Diện tích</th>
        <th>Trạng thái</th>
        <th>Tầng</th>
        <th>Loại văn phòng</th>
        <th>Giá thuê</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="matBang" items="${matBangList}">
        <tr>
            <td>${matBang.maMatBang}</td>
            <td>${matBang.dienTich}</td>
            <td>${matBang.trangThai}</td>
            <td>${matBang.tang}</td>
            <td>${matBang.loaiVanPhong}</td>
            <td>${matBang.giaTien}</td>
            <td>${matBang.ngayBatDau}</td>
            <td>${matBang.ngayKetThuc}</td>
            <td>
                <a href="/matbang?action=delete&maMatBang=${matBang.maMatBang}" onclick="return confirm('Bạn có chắc chắn muốn xóa mặt bằng này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
