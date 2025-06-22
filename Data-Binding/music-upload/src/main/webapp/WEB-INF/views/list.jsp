<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Uploaded Songs</title></head>
<body>
<h2>Danh sách bài hát</h2>

<table border="1">
  <tr>
    <th>Tên bài hát</th>
    <th>Nghệ sĩ</th>
    <th>Thể loại</th>
    <th>File</th>
  </tr>
  <c:forEach items="${songs}" var="song">
    <tr>
      <td>${song.name}</td>
      <td>${song.artist}</td>
      <td>${song.genre}</td>
      <td>${song.filePath}</td>
    </tr>
  </c:forEach>
</table>
<br/>
<a href="/songs/upload">Upload bài hát mới</a>
</body>
</html>
