<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
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
<div class="row mt-5">
		<div class="col-8 offset-2">
			<div class="row align-items-center">
				<div class="col">
					<h4>
						Namaste,
						<c:out value="${loggedUser.name}" />
						!
					</h4>
					<p>Course schedule:</p>
				</div>
				<div class="col text-end">
					<div class="row">
						<div class="col">
							<a class="btn btn-danger" href="/logout">Logout</a>
						</div>

					</div>
					
				</div>
			</div>
			<table class="table table-bordered text-center">
				<thead>
					<tr>
						<th scope="col">Class Name</th>
						<th scope="col">Instructor</th>
						<th scope="col">Weekday</th>
						<th scope="col" class="col-2">Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="course" items="${courses}">
						<tr>
						<td class="d-flex justify-content-around">
						<c:choose>
						<c:when test="${ loggedUser.id == course.instructor.id}">
						
							<a href="/classes/${course.id}"><c:out
										value="${course.name}" /></a>
										<a href="/classes/${course.id}/edit"
											class="btn  btn-warning">Edit</a>
										
								</c:when>
								<c:otherwise>
								<a href="/classes/${course.id}"><c:out
										value="${course.name}" /></a>
								
								</c:otherwise>
								</c:choose>		
								</td>		
							<td><c:out value="${course.instructor.name}" /></td>
							<td><c:out value="${course.day}"/></td>
							<td><c:out value="${course.price}" /></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div class="row">
						<div class="col">
							<a class="btn btn-success" href="/classes/new">+ New Course</a>
						</div>
					</div>

</body>
</html>