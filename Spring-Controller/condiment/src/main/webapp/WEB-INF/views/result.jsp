<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 15/06/2025
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Kết Quả</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f1f1f1;
      padding: 40px;
    }

    h2 {
      color: #2c3e50;
      margin-bottom: 20px;
    }

    ul {
      background: #ffffff;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 12px rgba(0, 0, 0, 0.15);
      max-width: 400px;
      list-style-type: none;
    }

    li {
      padding: 8px 12px;
      margin-bottom: 8px;
      background-color: #ecf0f1;
      border-radius: 5px;
    }

    li:last-child {
      margin-bottom: 0;
    }
  </style>
</head>
<body>
<h2>Các gia vị bạn đã chọn:</h2>
<ul>
  <c:forEach var="item" items="${condiments}">
    <li>${item}</li>
  </c:forEach>
</ul>
</body>
</html>

