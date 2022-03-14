<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>You have visited  <a href="#">http://your_server</a> <c:out value="${count}"></c:out> times.<a href="/your_server">Test another visit?</a> </h1>
</body>
</html>