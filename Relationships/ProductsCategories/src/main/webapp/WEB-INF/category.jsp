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
			<h2>New Category:</h2>
				<form:form action="/categories" method="post" modelAttribute="category">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = " name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					
					<button type="submit" class="btn btn-outline-warning align-self-center">Create</button>
				</form:form>
			</div>
		</div>

</body>
</html>