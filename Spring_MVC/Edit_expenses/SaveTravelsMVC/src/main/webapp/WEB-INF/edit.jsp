<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
				  <c:forEach var="item" items="${expenses}">
				    <tr>
				      <th scope="row"><c:out value="${item.name}"></c:out></th>
				      <td><c:out value="${item.vendor}"></c:out></td>
				      <td><c:out value="${item.amount}"></c:out>$</td>
				      <td><a href="/expenses/edit/${item.id}">edit</a></td>
				    </tr>
				    </c:forEach>
				    <div style="display:flex;justify-content: space-around">
				    <h1 style="color:#38761d">Edit Expense</h1>
				    <a href="/expenses">Go back</a>
				    </div>
				
		<div class = "row justify-content-center">
			<div class = "col-5 align-self-center">
				<form:form action="/expenses/edit/${expense.id}" method="put" modelAttribute="expense">
				<input type="hidden" name="_method" value="put">
					<div class="form-floating my-3">
					  <form:input path="name" class="form-control" name = "expense" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="name" for="floatingInput">Expense Name</form:label>
						<form:errors path="name" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="vendor" type="text" class="form-control" name = "vendor" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="vendor" for="floatingInput">Vendor</form:label>
						<form:errors path="vendor" class = "my-3"  style="color: red;"/>
					</div>
					<div class="form-floating mb-3">
					  <form:input path="amount" type="number" class="form-control" name = "amount" id="floatingInput" placeholder="name@example.com"/>
					  <form:label path="amount" for="floatingInput">Amount</form:label>
					<form:errors path="amount" class = "my-3" style="color: red;"/>
					</div>
					<div class="form-floating mb-4">
					  <form:textarea path="description" class="form-control" placeholder="Leave a comment here" name = "amount" id="floatingTextarea2" style="height: 100px"></form:textarea>
					  <form:label path="description" for="floatingTextarea2">Description</form:label>
					<form:errors path="description" class = "my-3" style="color: red;"/>
					</div>
					<button type="submit" class="btn btn-outline-warning align-self-center">Add</button>
				</form:form>
			</div>
		</div>
				
	</div>
</body>
</html>