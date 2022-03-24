<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Change your entry </title>
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
			<div class="col-6 offset-3">
				<div class="row mb-5">
					<div class="col">
						<h3>Edit Project!</h3>

					</div>
					<div class="col text-end">
						<a class="btn btn-dark"
								href="/dashboard">Dashboard</a>
					</div>
				</div>
				<div class="row">
					<div class="col text-start">
						<form:form action="/projects/${project.id}" method="post"
							modelAttribute="project">
							<input type="hidden" name="_method" value="put">
							<div class="mb-3">
								<form:errors class="text-danger" path="title" />
								<form:input type="text" class="form-control" id="title"
									path="title" placeholder="Title" />
							</div>
							<div class="mb-3">
								<form:errors class="text-danger" path="description" />
								<form:textarea type="text" class="form-control" id="description"
									path="description" placeholder="Description" ></form:textarea>
							</div>

							<div class="mb-3">
								<form:errors class="text-danger" path="duedate" />
								<form:input type="date" class="form-control" id="duedate"
									path="duedate" placeholder="Add your duedate" rows="3"/>
							</div>
							<button type="submit" class="btn btn-success float-end">Submit</button>
						</form:form>
						<a class="btn btn-dark" href="/dashboard">Cancel</a>
					</div>
					<div class="col">
							<form:form action="/projects/${project.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<button type="submit" class="btn btn-sm btn-danger">Delete</button>
							</form:form>
							
							
						</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>