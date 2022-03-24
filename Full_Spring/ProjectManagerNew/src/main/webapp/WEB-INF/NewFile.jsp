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

						<form:form action="/projects/${project.id}/tasks" method="post"
							modelAttribute="newTask">

							<div class="mb-3">
								<form:label path="ticket" class="form-label">Add a task ticket for this team:</form:label>
								<form:textarea class="form-control" path="ticket" rows="3"></form:textarea>
							</div>
							<button class="btn btn-success float-end">Submit</button>
						</form:form>
					

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>