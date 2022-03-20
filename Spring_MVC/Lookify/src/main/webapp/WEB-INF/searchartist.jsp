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
<title>Search</title>
</head>
<body>
	<div class="row">
		<div class="col-8 offset-2 text-center">
			<div class="row my-5 align-items-center">
				<div class="col">
					<p>
						Songs by artist:
						<c:out value="${result}" />
					</p>
				</div>
				<div class="col-4">
					<form action="/search">
						<div class="row">
							<div class="col p-0">
								<input class="form-control me-2" type="search"
									placeholder="Search" aria-label="Search" name="artist">
							</div>
							<div class="col p-0">
								<button class="btn btn-outline-success" type="submit">New
									Search</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col">
					<a class="btn btn-primary" href="/dashboard">Dashboard</a>
				</div>
			</div>
		</div>
	</div>

	<div class="row mt-5">
		<div class="col-6 offset-3">

			<div class="row">

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Rating</th>
							<th scope="col">Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="song" items="${songs}">
							<tr>
								<td><a href="/songs/<c:out value="${song.id}"/>"><c:out
											value="${song.title}" /></a></td>

								<td><c:out value="${song.rating}" /></td>
								<td>
									<form action="/songs/<c:out value="${song.id}"/>" method="post">
										<input type="hidden" name="_method" value="delete">
										<button class="btn btn-sm btn-danger">Delete</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


			</div>
		</div>
	</div>

	
</body>
</html>