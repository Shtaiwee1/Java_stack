<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!-- Bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- CSS -->
<!-- <link rel="stylesheet" type="text/css" href="css/fruity.css"> -->
</head>

<!-- Table in CSS -->
<!--  
	<body style='text-align:center;'>
		<div class="container" >
			<h1 style="color:#ef8080"  >Fruit Store</h1>
			<table style='border:10px solid #ffb6c2;'>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
				 	<c:forEach var="fruit" items="${item}">
				<tr>
					<td><c:out value="${fruit.name}"></c:out></td>
					<td><c:out value="${fruit.price}"></c:out> </td>
				</tr>
					</c:forEach>
			</table>
		</div>
		  -->
		<!-- Table in bootstrap -->
	<div style="font-size:25px;width:800px;margin:300px" >
		<h1 style="color:#ef8080; font-size:3.5rem"  >Fruit Store</h1>
		<table style="border:25px solid #ffb6c2;margin-top:45px"  class="table ">
		  <thead>
		    <tr>
		      <th style="border-bottom:0.5px solid #ffb6c2 " scope="col">Name</th>
		      <th style="border-bottom:0.5px solid #ffb6c2 " scope="col">Price</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="fruit" items="${item}">
		    <tr>
		      <td><c:out value="${fruit.name}"></c:out></td>
		      <td><c:out value="${fruit.price}"></c:out> </td>
		    </tr>
		      </c:forEach>
		   </tbody>
		  </table>
	  </div>
	</body>
</html>