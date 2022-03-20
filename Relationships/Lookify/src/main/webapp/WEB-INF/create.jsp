<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new song</title>
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

<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
			<h2>Add Song:</h2>
				<form:form action="/songs" method="post" modelAttribute="song">
					<div class="form-floating my-3">
					  <form:input path="title" class="form-control" name = "song name" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="title" for="floatingInput">Song Title</form:label>
						<form:errors path="title" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="artist" type="text" class="form-control" name = "creator" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="artist" for="floatingInput">Artist</form:label>
						<form:errors path="artist" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:select path="rating" type="number" class="form-control" name = "version" id="floatingInput" placeholder="name@example.com">
					  <%for (int i=0 ; i<11 ; i++){ %>
					  <form:option path="rating" value="<%=i %>"><%=i %></form:option>
					  <%} %>
					  </form:select>
					  <form:label path="rating" for="floatingInput">Rating(1-10)</form:label>
					<form:errors path="rating" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-warning align-self-center">Add song</button>
				</form:form>
			</div>
		</div>

</body>
</html>