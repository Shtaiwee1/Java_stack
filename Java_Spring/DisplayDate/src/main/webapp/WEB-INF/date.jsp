<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
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
<!-- JS -->
<script type="text/javascript" src="js/date.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="/css/date.css">
</head>
<body>

<div class="row mt-5">
		<div class="col-6 offset-3">
		
<h1 class="col my-5" style='text-align:center;'><c:out value="${date}"></c:out>  </h1>

</div>
</div>

</body>
</html>