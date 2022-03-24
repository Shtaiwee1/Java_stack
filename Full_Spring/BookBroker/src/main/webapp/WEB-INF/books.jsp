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
	<div class="row mt-5">
		<div class="col-8 offset-2">
			<div class="row align-items-center">
				<div class="col">
					<h1 class="welcome">
						Welcome,
						<c:out value="${thisUser.userName}" />
						!
					</h1>
					<p>Books from evereyone's shelves:</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col mb-3">
							<a class="btn btn-danger" href="/logout">Logout</a>
						</div>

					</div>
					
					<div class="row">
						<div class="col mb-3">
							<a class="btn btn-primary" href="/bookmarket">See Bookmarket!</a>
						</div>
					</div>
				</div>

			</div>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author Name</th>
						<th scope="col">Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>

							<td><c:out value="${book.id}" /></td>
							<td>
							<a style="text-decoration: none" href="/books/${book.id}"><c:out value="${book.title}" /></a>
							</td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.userName}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="col text-end">
				<div class="row">
					<div class="col mb-3">
						<a class="btn btn-success" href="/books/new">+Add a book to my shelf!</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>