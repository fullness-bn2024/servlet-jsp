<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>書籍一覧</title>
</head>
<body>
<h2>書籍一覧</h2>
<form action="book" method="get">
  著者名でフィルタ<br>
  <input type="text" name="author">
  <input type="submit" value="検索">
</form>
<table border="1">
  <tr>
    <th>書籍ID</th>
    <th>タイトル</th>
    <th>著者</th>
  </tr>
  <c:forEach var="book" items="${books}">
    <tr>
      <td>${book.getId()}</td>
      <td>${book.getTitle()}</td>
      <td>${book.getAuthor()}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>