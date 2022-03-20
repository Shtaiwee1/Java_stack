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
				<div class="col-6">
					<a href="/dojos/new" class="btn btn-primary">Add Dojo</a>
				</div>
				<div class="col-6">
					<a href="/ninjas/new" class="btn btn-primary">Add Ninja</a>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-6">
					<h1>All Dojos</h1>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dojo" items="${dojos}">
						<tr>
							<td><a href="/dojos/${dojo.id}"><c:out
										value="${dojo.name}" /></a></td>
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