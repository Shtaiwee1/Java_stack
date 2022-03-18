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

<div style="display:flex;justify-content: space-evenly;margin:60px;align-items:center">
				    <h1 style="color:#38761d;font-size:3.5rem">Expense Details</h1>
				    <a href="/expenses">Go back</a>
				    </div>
<div style="margin-left:360px">
<h2>Expense Name:<c:out value="${expense.name}"></c:out></h2>
<h2>Expense Description: <c:out value="${expense.description}"/></h2>
<h2>Vendor: <c:out value="${expense.vendor}"/></h2>
<h2>Amount Spent: <c:out value="${expense.amount}"/></h2>
</div>
</body>
</html>