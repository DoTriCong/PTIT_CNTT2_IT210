<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/04/2026
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Chi tiết</h1>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.name}"/></td>
            <td><c:out value="${order.price}"/></td>
            <td><c:out value="${order.quantity}"/></td>
            <td><c:out value="${order.total}"/></td>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
