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
			<div class="col-8 offset-2">
				<div class="row">
					<div class="col-8">

						<h2>
							Project:
							<c:out value="${project.title}" />

						</h2>
						<p>
							Project Lead:
							<c:out value="${project.creator.firstName}" />
						</p>
					</div>
					<div class="col text-end">
						<a href="/dashboard">Back to Dashboard</a>

					</div>
				</div>
				<div class="row my-4">
					<div class="col">
						<form:form action="/projects/${project.id}/tasks" method="post"
							modelAttribute="newTask">

							<div class="mb-3">
								<form:errors class="text-danger" path="ticket" />
								<form:textarea class="form-control" path="ticket" rows="3"
									placeholder="Ticket"></form:textarea>
							</div>
							<button class="btn btn-success float-end">Submit</button>
						</form:form>
					</div>

				</div>
				<div class="row">
					<div class="col">
						<ul class="list-group list-group-flush">
							<c:forEach var="task" items="${project.tasks}">
								<li class="list-group-item"><strong> Added by <c:out
											value="${task.user.firstName}" /> <fmt:formatDate
											value="${task.createdAt}" pattern="h:m a MMM dd,yyyy" />
								</strong>
									<p>
										<c:out value="${task.ticket}" />
									</p></li>

							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>