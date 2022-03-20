<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<%@ page isErrorPage="true" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row my-5 mx-5">
				<div class="col">
					<a class="btn btn-dark" href="/">Home</a>
				</div>
			</div>

<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h2>New Ninja:</h2>
				<form:form action="/ninjas" method="post" modelAttribute="ninja">
					<div class="form-floating mb-3">
					  <form:select path="dojo" type="text" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com">
					  <c:forEach var="dojo" items="${dojos}">
						<form:option path="dojo" value="${dojo.id}"><c:out value="${dojo.name}" /></form:option>
						</c:forEach>
					  
					  </form:select>
					  <form:label path="dojo" for="floatingInput">Dojo</form:label>
					<form:errors path="dojo" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating my-3">
					  <form:input path="firstName" class="form-control" name = "ninja name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="firstName" for="floatingInput">First Name:</form:label>
						<form:errors path="firstName" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating my-3">
					  <form:input path="lastName" class="form-control" name = "ninja name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="lastName" for="floatingInput">Last Name:</form:label>
						<form:errors path="lastName" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating my-3">
					  <form:input path="age" class="form-control" name = "ninja name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="age" for="floatingInput">Age:</form:label>
						<form:errors path="age" class = "my-3" style="color: red;"/>
					</div>
					
					<button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
				</form:form>
			</div>
		</div>

</body>
</html>