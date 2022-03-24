<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Dashboard</title>
</head>
<body>
	<div class="row mt-5">
		<div class="col-8 offset-2">
			<div class="row align-items-center">
				<div class="col">
					<h4>
						Welcome,
						<c:out value="${loggedUser.firstName}" />
						!
					</h4>
					<p>All projects:</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col">
							<a href="/logout">Logout</a>
						</div>

					</div>
					<div class="row">
						<div class="col">
							<a href="/projects/new">+ New Project</a>
						</div>
					</div>
				</div>

			</div>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">Project Title</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${projectsNotPartOf}">
						<tr>
							<td><a href="/projects/${project.id}"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.creator.firstName}" /></td>
							<td><fmt:formatDate value="${project.dueDate}" type="date" /></td>
							<td><form:form action="/projects/${project.id}/join"
									method="post">
									<input type="hidden" name="_method" value="put">
									<button type="submit" class="btn btn-sm btn-warning">Join
										Team!</button>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p class="mt-5">Your Projects:</p>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">Project Title</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${loggedUser.projects}">
						<tr>
							<td><a href="/projects/${project.id}"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.creator.firstName}" /></td>
							<td><fmt:formatDate value="${project.dueDate}" type="date" /></td>
							<td><c:choose>

									<c:when test="${project.creator.id == loggedUser.id}">

										<a href="/projects/edit/${project.id}"
											class="btn btn-sm btn-success">Edit</a>
									</c:when>
									<c:otherwise>
										<form:form action="/projects/${project.id}/leave"
											method="post">
											<input type="hidden" name="_method" value="put">
											<button type="submit" class="btn btn-sm btn-danger">Leave
												Team!</button>
										</form:form>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>