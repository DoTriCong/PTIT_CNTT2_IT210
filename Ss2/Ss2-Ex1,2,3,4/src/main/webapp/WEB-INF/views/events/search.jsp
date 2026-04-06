<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/04/2026
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày tổ chức</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach varStatus="loop" var="e" items="${events}">
            <tr>
                <td>${loop.index + 1}</td>
                <td>
                    <c:out value="${e.name}"/>
                </td>
                <td>
                    <c:out value="${e.eventDate}"/>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${e.price >0}">
                            <fmt:formatNumber type="currency" currencySymbol="VND" value="${e.price}"/>
                        </c:when>
                        <c:otherwise>
                            Miễn phí
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${e.remainingTickets < 10}">
                            Sắp hết
                        </c:when>
                        <c:when test="${e.remainingTickets == 0}">
                            Hết vé
                        </c:when>
                        <c:otherwise>
                            ${e.remainingTickets}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:url value="/events/${e.id}" var="url"/>
                    <c:if test="${e.remainingTickets >0}">
                        <a href="${url}">Đặt vé</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
        <tfoot>
        </tfoot>
    </table>
</div>
</body>
</html>
