<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 15/06/2025
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Email Display</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 0;
    }

    h3 {
      color: #4CAF50;
      text-align: center;
      font-size: 24px;
      margin-top: 50px;
    }

    .container {
      width: 80%;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
      text-align: center;
    }

    .email-display {
      color: #333;
      font-size: 18px;
      margin-top: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <h3>Hi ${email}</h3>
  <div class="email-display">
    Your email address is: <strong>${email}</strong>
  </div>
</div>
</body>
</html>

