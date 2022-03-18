<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Languages</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
				
		<div class = "row justify-content-center">
		<div style="display:flex;justify-content: space-evenly;margin:60px;align-items:center">
		<div style="display:flex;justify-content: flex-end;">
				    <a href="/languages"><form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <button style="margin-left: 30px;" type="submit" value="delete" class="btn btn-danger align-self-center">delete</button>
</form></a>
				    <a href="/languages">Dashboard</a>
				    </div>
				    </div>
			<div class = "col-5 align-self-center">
				<form:form action="/languages/${language.id}/edit" method="post" modelAttribute="language">
				<input type="hidden" name="_method" value="put">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = "language name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Language Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="creator" type="text" class="form-control" name = "creator" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="creator" for="floatingInput">Creator</form:label>
						<form:errors path="creator" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="version" type="number" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="version" >Version</form:label>
					  <form:label path="version" for="floatingInput">Version</form:label>
					<form:errors path="version" class = "my-3" style="color: red;"/>
					</div>
					
					<button type="submit" class="btn btn-outline-warning align-self-center">Submit</button>
				</form:form>
			</div>
		</div>
				
	</div>
</body>
</html>