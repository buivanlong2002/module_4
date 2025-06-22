<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Tờ khai y tế</title></head>
<body>
<h2>TỜ KHAI Y TẾ</h2>
<form:form modelAttribute="declaration" method="post">

    Họ tên: <form:input path="fullName"/>
    <form:errors path="fullName" cssClass="error"/><br/>

    Năm sinh: <form:input path="yearOfBirth" type="number"/>
    <form:errors path="yearOfBirth" cssClass="error"/><br/>

    Giới tính:
    <form:radiobutton path="gender" value="Nam"/> Nam
    <form:radiobutton path="gender" value="Nữ"/> Nữ
    <form:errors path="gender" cssClass="error"/><br/>

    Quốc tịch: <form:input path="nationality"/>
    <form:errors path="nationality" cssClass="error"/><br/>

    Số CMND/CCCD: <form:input path="idCard"/>
    <form:errors path="idCard" cssClass="error"/><br/>

    ... <!-- Các trường khác tương tự -->

    <input type="submit" value="GỬI TỜ KHAI"/>
</form:form>
</body>
</html>
