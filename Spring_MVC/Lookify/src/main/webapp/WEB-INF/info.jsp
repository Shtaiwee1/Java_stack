<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs info</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div style="margin-right:50px" class="position-absolute top-10 end-0"><a href="/dashboard">Dashboard</a></div>

<div style="display:flex;justify-content: space-evenly;margin:60px;align-items:center">
				    <h1 style="color:#38761d;font-size:3.5rem">Song Details</h1>
				    
				    </div>
<div style="margin-left:360px">
<h2>Title:<c:out value="${song.title}"></c:out></h2>
<h2> Artist: <c:out value="${song.artist}"/></h2>
<h2>Rating: <c:out value="${song.rating}"/></h2>
<form action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <button style="margin-top: 20px;" type="submit" value="delete" class="btn btn-danger align-self-center">Delete</button>
</form>
</div>

</body>
</html>