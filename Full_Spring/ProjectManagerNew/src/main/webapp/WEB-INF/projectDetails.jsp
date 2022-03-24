<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Add a new Book</title>
</head>
<body>

	<div class="container">
		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row my-3">
					<div class="col">
						<h2>Project Details</h2>
					</div>
					<div class="col text-end">
						<a href="/dashboard">Back to Dashboard</a>
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Project:</div>
					<div class="col">
						<c:out value="${project.title}" />
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Description:</div>
					<div class="col">
						<c:out value="${project.description}" />
					</div>
				</div>
				<div class="row my-5">
					<div class="col-4">Due Date:</div>
					<div class="col">
						<fmt:formatDate value="${project.dueDate}" pattern="M/dd/yyyy" />
					</div>
				</div>
				<div class="row">
					<div class="col">
						<a href="/projects/${project.id}/tasks">See Tasks!</a>
					</div>
				</div>
				<c:if test="${project.creator.id == loggedUser.id}">
					<div class="row text-end">
						<div class="col">
							<form:form action="/projects/${project.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<button type="submit" class="btn btn-sm btn-danger">Delete
									Project!</button>
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