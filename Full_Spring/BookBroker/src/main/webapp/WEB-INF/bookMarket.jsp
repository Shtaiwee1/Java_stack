<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Bookmarket</title>
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
					<h4>
						Hello,
						<c:out value="${loggedInUser.userName}" />
						. Welcome to..
					</h4>
					<h2>The Book Broker!</h2>
					<p>Available Books to Borrow:</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col">
							<a href="/logout">Logout</a>
						</div>

					</div>
					<div class="row">
						<div class="col">
							<a href="/books/new">+Add to my shelf!</a>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<a href="/books">Back to the shelves</a>
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
						<th scope="col">Owner</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${availabeBooks}">
						<tr>

							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/<c:out value="${book.id}"/>"><c:out
										value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.userName}" /></td>
							<td><c:choose>
									<c:when test="${book.user.id != loggedUser.id}">
										<form:form action="/books/${book.id}" method="post">
											<button type="submit" class="btn btn-sm btn-success">Borrow</button>
										</form:form>
									</c:when>
									<c:otherwise>
										<div class="row">
											<div class="col">
												<a class="btn btn-sm btn-primary"
													href="/books/${book.id}/edit">Edit</a>
											</div>
											<div class="col">
												<form:form action="/books/${book.id}" method="post">
													<input type="hidden" name="_method" value="delete">
													<button type="submit" class="btn btn-sm btn-danger">Delete</button>
												</form:form>
											</div>
										</div>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>Books you are borrowing:</p>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author Name</th>
						<th scope="col">Owner</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${borrowedBooks}">
						<tr>
							<td><c:out value="${book.id}" /></td>
							<td><a href="/books/${book.id}"><c:out
										value="${book.title}" /></a></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.user.userName}" /></td>
							<td><form:form action="/books/${book.id}/return" method="post">
									<input type="hidden" name="_method" value="put">
									<button type="submit" class="btn btn-sm btn-warning">Return</button>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>