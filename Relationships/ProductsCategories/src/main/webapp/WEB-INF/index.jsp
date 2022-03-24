<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<%@ page isErrorPage="true" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row">
		<div class="col-6 offset-3">
			<div class="row my-5">
				<div class="col-6">
					<a href="/categories/new" class="btn btn-primary">Add Category</a>
				</div>
				<div class="col-6">
					<a href="/products/new" class="btn btn-primary">Add Product</a>
				</div>
			</div>
			<div class="row my-5">
				<div class="col-6">
					<h1>All categories</h1>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="category" items="${categories}">
						<tr>
							<td><a style="text-decoration: none" href="/categories/${category.id}"><c:out
										value="${category.name}" /></a></td>
						</tr>
					</c:forEach>



				</tbody>
			</table>
			
			<div class="row my-5">
				<div class="col-6">
					<h1>All products</h1>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Name</th>
						<th scope="col">Description</th>
						<th scope="col">Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${products}">
						<tr>
							<td><a style="text-decoration: none" href="/categories/${product.id}"><c:out
										value="${product.name}" /></a></td>
							<td><c:out value="${product.description}"></c:out>     </td>
							<td><c:out value="${product.price}"></c:out>     </td>
						</tr>
					</c:forEach>



				</tbody>
			</table>
		</div>
	</div>


</body>
</html>