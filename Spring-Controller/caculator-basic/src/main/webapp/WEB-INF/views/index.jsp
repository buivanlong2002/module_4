<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Máy tính đơn giản</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding: 30px;
        }
        h2 {
            color: #333;
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.15);
        }
        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            color: #555;
        }
        input[type="number"], select {
            width: 100%;
            padding: 8px 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1rem;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px 0;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 1.1rem;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .result, .error {
            max-width: 400px;
            margin: 20px auto;
            padding: 15px;
            border-radius: 6px;
            font-size: 1.1rem;
            text-align: center;
        }
        .result {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
<h2>Máy tính đơn giản</h2>

<form action="calculate" method="post">
    <label for="num1">Số thứ nhất:</label>
    <input type="number" id="num1" name="num1" step="any" value="${num1}"/>

    <label for="num2">Số thứ hai:</label>
    <input type="number" id="num2" name="num2" step="any" value="${num2}"/>

    <label for="operation">Phép toán:</label>
    <select id="operation" name="operation">
        <option value="add" ${operation == 'add' ? 'selected' : ''}>Cộng</option>
        <option value="sub" ${operation == 'sub' ? 'selected' : ''}>Trừ</option>
        <option value="mul" ${operation == 'mul' ? 'selected' : ''}>Nhân</option>
        <option value="div" ${operation == 'div' ? 'selected' : ''}>Chia</option>
    </select>

    <input type="submit" value="Tính"/>
</form>

<c:if test="${not empty error}">
    <div class="error">${error}</div>
</c:if>

<c:if test="${not empty result}">
    <div class="result">Kết quả: ${result}</div>
</c:if>

</body>
</html>
