<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>掲示板</title>
</head>
<body>
<h2>メッセージ一覧</h2>
<ul>
  <c:forEach var="msg" items="${messages}">
    <li>${msg}</li>
  </c:forEach>
</ul>
<h2>メッセージ登録</h2>
<form action="keijiban" method="post">
  メッセージ<br>
  <textarea cols="60" rows="4" name="message"></textarea><br>
  <div>
    <input type="submit" name="confirm" value="確認"/>
  </div>
</form>
</body>
</html>