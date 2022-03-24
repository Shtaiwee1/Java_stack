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
<title>Book Details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row my-5">
			<div class="col-8 offset-2">
				<div class="row my-4">
					<div class="col-8">
						<h2>
							<c:out value="${book.title}" />
						</h2>
					</div>
					<div class="col text-end">
						<a class="btn btn-dark"
								href="/books">Back to the shelves</a>
					</div>
				</div>
				<div class="row">
					<c:choose>
						<c:when test="${book.user.id != thisUserId}">
							<h4 class="my-3">
								<span class="user"><c:out value="${book.user.userName}" /></span>
								read <span class="title"><c:out value="${book.title}" /></span>
								by <span class="author"><c:out value="${book.author}" /></span>
							</h4>
							<h5>
								Here are
								<c:out value="${book.user.userName}" />
								's thoughts:
							</h5>
						</c:when>
						<c:otherwise>
							<h4 class="my-3">
								<span class="user">You</span> read <span class="title"><c:out
										value="${book.title}" /></span> by <span class="author"><c:out
										value="${book.author}" /></span>
							</h4>
							<h5>Here are your thoughts:</h5>
						</c:otherwise>
					</c:choose>


				</div>
				<div
					class="row mt-4 border-top border-bottom border-dark border-2 py-3">
					<p>
						<c:out value="${book.thoughts}" />
					</p>
				</div>
				<c:if test="${book.user.id == thisUserId}" var="res">
					<div class="col my-4">
						<div class="col">
							<a class="btn btn-warning"
								href="/books/${book.id}/edit">Edit</a>
						</div>
					</div>

				</c:if>

			</div>
		</div>
	</div>
</body>
</html>