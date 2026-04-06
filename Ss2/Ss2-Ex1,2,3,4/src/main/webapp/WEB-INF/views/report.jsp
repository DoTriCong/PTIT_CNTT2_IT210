<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Điểm</th>
            <th>Xếp hạng</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="s" items="${studentList}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${s.fullName}</td>
                <td>${s.score}</td>
                <c:choose>
                    <c:when test="${s.score >=90}">
                        <td>Xuất xắc</td>
                    </c:when>
                    <c:when test="${s.score >=80}">
                        <td>Giỏi</td>
                    </c:when>
                    <c:when test="${s.score >=70}">
                        <td>Khá</td>
                    </c:when>
                    <c:when test="${s.score >=60}">
                        <td>Trung bình khá</td>
                    </c:when>
                    <c:when test="${s.score >=50}">
                        <td>Khá</td>
                    </c:when>
                    <c:otherwise>
                        <td>Yếu</td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>