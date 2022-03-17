<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body>
<h1><c:out value="${book.title}"></c:out></h1>
<h2>Description: <c:out value="${book.description}"/></h2>
<h2>Language: <c:out value="${book.language}"/></h2>
<h2>Number of pages: <c:out value="${book.numberOfPages}"/></h2>

</body>
</html>