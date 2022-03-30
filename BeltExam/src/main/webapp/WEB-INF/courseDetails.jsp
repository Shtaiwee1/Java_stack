<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Course Details</title>
</head>
<body>

	<div class="container">
		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row my-3">
					<div class="col">
						<h2><c:out value="${course.name}" /></h2>
					</div>
					<div class="col text-end">
						<a href="/classes">Back to Homepage</a>
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Instructor:</div>
					<div class="col">
						<c:out value="${course.instructor.name}" />
					</div>
				</div>
				
				<div class="row my-5">
					<div class="col-4">Day:</div>
					<div class="col">
						<c:out value="${course.day}" />
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Cost:</div>
					<div class="col">
						$<c:out value="${course.price}"  />
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Description:</div>
					<div class="col">
						<c:out value="${course.description}" />
					</div>
				</div>
				<c:if test="${course.instructor.id == loggedUser.id}">
					<div class="row text-end">
						<div class="col">
							<form:form action="/classes/${course.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<button type="submit" class="btn btn-sm btn-danger">Delete
									Course!</button>
							</form:form>
						</div>
					</div>
				</c:if>
				

			</div>
		</div>

	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>