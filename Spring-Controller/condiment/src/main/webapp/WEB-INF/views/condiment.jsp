<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 15/06/2025
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chọn Gia Vị</title>
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

    form {
      background: #ffffff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 12px rgba(0, 0, 0, 0.15);
      max-width: 400px;
    }

    input[type="checkbox"] {
      margin: 10px 0;
    }

    input[type="submit"] {
      margin-top: 20px;
      padding: 10px 20px;
      background-color: #3498db;
      color: white;
      border: none;
      border-radius: 5px;
      font-weight: bold;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
<h2>Chọn gia vị ăn kèm với Sandwich:</h2>
<form action="save" method="post">
  <input type="checkbox" name="condiment" value="Lettuce"> Lettuce <br/>
  <input type="checkbox" name="condiment" value="Tomato"> Tomato <br/>
  <input type="checkbox" name="condiment" value="Mustard"> Mustard <br/>
  <input type="checkbox" name="condiment" value="Mayonnaise"> Mayonnaise <br/>
  <input type="submit" value="Gửi lựa chọn"/>
</form>
</body>
</html>


