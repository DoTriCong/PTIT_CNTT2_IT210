<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 08/04/2026
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="o" items="${orders}">
            <tr>
                <td>
                    <c:out value="${o.id}"/>
                </td>
                <td>
                    <c:out value="${o.name}"/>
                </td>
                <td>
                    <c:out value="${o.price}"/>
                </td>
                <td>
                    <c:out value="${o.quantity}"/>
                </td>
                <td>
                    <c:out value="${o.total}"/>
                </td>
                <td>
                    <c:url value="/bai5/orders/${o.id}" var="orderUrl"/>
                    <a href="${orderUrl}">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
