<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>

	<div class="row">
		<div class="col-6 offset-3">
			<div class="row my-5">
				<div class="col">
					<a class="btn btn-primary" href="/">Home</a>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-6 offset-3">
					<h2>
						<c:out value="${dojo.name}" />
						Ninjas
					</h2>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>

						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="ninja" items="${dojo.ninjas}">
						<tr>
							<td><c:out value="${ninja.firstName}" /></td>
							<td><c:out value="${ninja.lastName}" /></td>
							<td><c:out value="${ninja.age}" /></td>
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