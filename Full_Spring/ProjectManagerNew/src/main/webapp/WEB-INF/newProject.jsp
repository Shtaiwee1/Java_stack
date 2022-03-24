<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
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
				<div class="row mb-5">
					<div class="col">
						<h3>Create a project</h3>

					</div>
					<div class="col text-end">
						<a href="/dashboard">Back to dasboard</a>
					</div>
				</div>
				<div class="row">
					<div class="col text-start">

						<form:form action="/projects" method="post"
							modelAttribute="newProject">
							<div class="mb-3">
								<form:errors class="text-danger" path="title" />
								<form:input type="text" class="form-control" id="title"
									path="title" placeholder="Title" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="description" />
								<form:textarea class="form-control" id="description"
									path="description" placeholder="Description" rows="3"></form:textarea>
							</div>

							<div class="mb-3">
								<form:errors class="text-danger" path="dueDate" />
								<form:input class="form-control" type="date" id="dueDate"
									path="dueDate" rows="3"></form:input>
							</div>
							<button type="submit" class="btn btn-success float-end ms-2">Submit</button>
							<a href="/dashboard" class="btn btn-danger float-end">Cancel</a>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>