<%--
  Created by IntelliJ IDEA.
  User: Hoang Tran
  Date: 18/06/2025
  Time: 00:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Upload Song</title></head>
<body>
<h2>Upload Song</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form:form modelAttribute="song" method="post" enctype="multipart/form-data">
    <p>
        Tên bài hát: <form:input path="name"/>
    </p>
    <p>
        Nghệ sĩ thể hiện: <form:input path="artist"/>
    </p>
    <p>
        Thể loại:
        <form:select path="genre">
            <form:options items="${genres}"/>
        </form:select>
    </p>
    <p>
        File nhạc: <input type="file" name="musicFile" accept=".mp3,.wav,.ogg,.m4p"/>
    </p>
    <input type="submit" value="Upload"/>
</form:form>
</body>
</html>

