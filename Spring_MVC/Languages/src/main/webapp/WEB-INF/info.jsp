<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
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
 <div style="margin-right:50px" class="position-absolute top-10 end-0"><a href="/languages">Dashboard</a></div>

<div style="display:flex;justify-content: space-evenly;margin:60px;align-items:center">
				    <h1 style="color:#38761d;font-size:3.5rem">Language Details</h1>
				    
				    </div>
<div style="margin-left:360px">
<h2>Language Name:<c:out value="${language.name}"></c:out></h2>
<h2> Creator: <c:out value="${language.creator}"/></h2>
<h2>Version: <c:out value="${language.version}"/></h2>
<a style="margin-top: 20px;" href="/languages/${language.id}/edit">Edit</a>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <button style="margin-top: 20px;" type="submit" value="delete" class="btn btn-danger align-self-center">delete</button>
</form>
</div>

</body>
</html>