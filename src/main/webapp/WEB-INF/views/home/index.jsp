<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tranh chủ</title>
</head>
<body>
  <h1>HOME PAGE</h1>
  <c:forEach items="${ users }" var="item">
    <p>${ item.id }</p>
    <p>${ item.email }</p>
  </c:forEach>
</body>
</html>