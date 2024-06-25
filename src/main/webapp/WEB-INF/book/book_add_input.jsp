<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>書籍登録</title>
  <style>
    body{ text-align: center;}
  </style>
</head>
<body>
<h2>書籍登録</h2>
<form action="add" method="post">
  タイトル <input type="text" name="title"><br>
  著者 <input type="text" name="author"><br>
  <input type="hidden" name="csrfToken" value="${csrfToken}">
  <input type="submit" value="登録">
</form>
</body>
</html>