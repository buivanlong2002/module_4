<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Chuyển đổi USD sang VNĐ</title>
</head>
<body>
<h2>Chuyển đổi USD sang VNĐ</h2>
<form action="convert" method="post">
    Tỉ giá (VND/USD): <input type="text" name="rate"/><br/>
    Số tiền USD: <input type="text" name="usd"/><br/>
    <input type="submit" value="Chuyển đổi"/>
</form>
</body>
</html>
