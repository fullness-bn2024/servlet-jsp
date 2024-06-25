<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>書籍登録</title>
  <style>
    body{ text-align: center;}
  </style>
</head>
<body>
<h2>書籍登録</h2>
<form action="add/complete" method="post">
  タイトル <c:out value="${title}" /><br>
  著者 <c:out value="${author}" /><br>
  <input type="hidden" name="title" value="${title}">
  <input type="hidden" name="author" value="${author}">
  <input type="hidden" name="csrfToken" value="${csrfToken}">
  <input type="submit" value="登録">
</form>
</body>
</html>