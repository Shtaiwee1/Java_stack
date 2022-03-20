<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Top Ten</title>
</head>
<body>
	<div class="row mt-5">
		<div class="col-6 offset-3">
			<div class="row my-3">
				<div class="col">
					<p>Top 10 songs:</p>
				</div>
				<div class="col">
					<a class="float-end btn btn-primary" href="/dashboard">Dashboard</a>
				</div>
			</div>
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Artist</th>
							<th scope="col">Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${songs}">
							<tr>
								<td><a href="/songs/<c:out value="${song.id}"/>"><c:out
											value="${song.title}" /></a></td>

								<td><c:out value="${song.artist}" /></td>
								<td><c:out value="${song.rating}" /></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>


			</div>
		</div>
	</div>

	
</body>
</html>