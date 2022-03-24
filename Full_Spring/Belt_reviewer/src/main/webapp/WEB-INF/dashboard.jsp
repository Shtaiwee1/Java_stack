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
<title>Project Manager</title>
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
						Welcome,
						<c:out value="${loggedInUser.firstName}" />
						
					</h4>
					<h2>The Project Manager!</h2>
					<p>All projects</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col">
							<a href="/logout">Logout</a>
						</div>

					</div>
					<div class="row">
						<div class="col">
							<a href="/projects/new">+New project!</a>
						</div>
					</div>
				</div>

			</div>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${availabeProjects}">
						<tr>

							<td><c:out value="${project.id}" /></td>
							<td><a href="/projects/<c:out value="${project.id}"/>"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.teamLead.firstName}" /></td>
							<td><c:out value="${project.duedate}" /></td>
							
							<td><form:form action="/projects/join/${project.id}" method="post">
							<input type="hidden" name="_method" value="put">
									<button type="submit" class="btn btn-sm btn-success">Join team</button>
								</form:form>
							</td>
							</tr>	
					</c:forEach>
				</tbody>
			</table>
			
			
			<p>Your Projects:</p>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Project</th>
						<th scope="col">Team Lead</th>
						<th scope="col">Due Date</th>
						<th scope="col" class="col-2">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${loggedInUser.projects}">
						<tr>
							<td><c:out value="${project.id}" /></td>
							<td><a href="/projects/${project.id}"><c:out
										value="${project.title}" /></a></td>
							<td><c:out value="${project.teamLead.firstName}" /></td>
							<td><c:out value="${project.duedate}" /></td>
							<td><c:choose>
								<c:when test="${loggedInUser.id != project.teamLead.id}">
								<form:form action="/projects/leave/${project.id}" method="post">
									<input type="hidden" name="_method" value="put">
									<button type="submit" class="btn btn-sm btn-warning">Leave Team</button>
									</form:form>
								</c:when>
								<c:otherwise>
								<div class="row">
											<div class="col">
												<a class="btn btn-sm btn-primary"
													href="/projects/edit/${project.id}">Edit</a>
											</div>
											<div class="col">
												<form:form action="/projects/${project.id}" method="post">
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
		</div>
	</div>
</body>
</html>