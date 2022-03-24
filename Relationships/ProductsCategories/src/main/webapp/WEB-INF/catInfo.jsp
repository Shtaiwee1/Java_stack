<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category details</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row my-5">
		<div class="col-4 offset-4">
			<div class="row align-items-center">
				<div class="col">
					<h2>
						<c:out value="${category.name}" />
					</h2>
				</div>
				<div class="col">
					<a class="btn btn-dark float-end" href="/">Home</a>
				</div>

			</div>
			<div class="row my-5"></div>
			<div class="row">
				<div class="col">
					<h4>Products:</h4>
					<ul>
						<c:forEach var="product" items="${category.products}">
							<li><c:out value="${product.name}" /></li>
						</c:forEach>
					</ul>
				</div>
				<div class="col">
					<form class="float-end" action="/categories/${category.id}"
						method="post">
						<input type="hidden" name="_method" value="put">
						<div class="mb-3">
							<label for="products" class="form-label">Add a product:</label> <select
								name="id">
								<c:forEach var="product" items="${products}">

									<option value="${product.id}">
										<c:out value="${product.name}" />
									</option>
								</c:forEach>
							</select>
						</div>
						<button class="btn btn-primary">Add</button>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>