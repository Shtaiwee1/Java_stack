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
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "row justify-content-center mb-5">
			<div class = "col-5 align-self-center ">
			<div style="display:flex;justify-content: space-between;align-items: center">
				<div>
				<a class="btn btn-primary" href="/songs/new" role="button">Add New</a>
				<a class="btn btn-primary" href="/search/topTen" role="button">Top Songs</a>
			
				</div>
				<div>
				<form:form action="/search" method="get" modelAttribute="song" style="display:flex">
				<div class="form-floating mb-3">
					  <form:input path="artist" type="text" class="form-control" name = "artist" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="artist" for="floatingInput">Artist</form:label>
					<form:errors path="artist" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-success align-self-center">Search Artists</button>
				</form:form>
				</div>
				</div>
				<table class="table border col-5 mb-5">
				  <thead>
				    <tr>
				      <th scope="col">Name</th>
				      <th scope="col">Rating</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach var="song" items="${songs}">
				    <tr>
				      <th scope="row"><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></th>
				      <td><c:out value="${song.rating}"></c:out></td>
				      <td style="display:flex;justify-content: space-between;background:none"><form action="/songs/${song.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <button style="margin-left: 30px;" type="submit" value="delete" class="btn btn-danger align-self-center">delete</button>
</form></td>
				    </tr>
				    </c:forEach>
				</table>
			</div>
		</div>

</body>
</html>