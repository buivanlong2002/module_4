<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Kết quả</title></head>
<body>
<h2>Thông tin đã khai báo</h2>
<p>Họ tên: ${declaration.fullName}</p>
<p>Năm sinh: ${declaration.yearOfBirth}</p>
<p>Giới tính: ${declaration.gender}</p>
<p>Quốc tịch: ${declaration.nationality}</p>
...
</body>
</html>
