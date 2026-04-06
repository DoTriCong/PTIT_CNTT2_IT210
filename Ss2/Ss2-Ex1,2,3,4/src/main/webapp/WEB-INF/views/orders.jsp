<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2026
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p>Xin chao nhân viên ${username}! Vai trò: ${role}</p>
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên đơn hàng</th>
            <th>Giá tiền</th>
            <th>Ngày đặt</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="o" items="${list}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${o.name}</td>
                <td>
                    <f:formatNumber value="${o.price}" type="currency" currencyCode="VND"/>
                </td>
                <td>
                    <f:formatDate value="${o.createdAt}" pattern="dd/MM/yyyy"/>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p>Tổng số lượt xem: ${count}</p>
    <a href="/logout">Đăng xuất</a>
</div>
</body>
</html>
