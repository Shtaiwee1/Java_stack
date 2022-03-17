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
</head>
<body>
<h1>All Books</h1>

<table>
    <thead>
    <tr>
   	 	<th>ID</th>
		<th>Title</th>
		<th>Language</th>
		<th>Number of Pages</th>
   	</tr>
    </thead>
    <tbody>
        <c:forEach var="item" items="${books}">
        <tr>
            <td><c:out value="${item.id}"></c:out> </td>
            <td><a> <c:out value="${item.title}"></c:out></a></td>
            <td><c:out value="${item.description}"></c:out></td>
            <td><c:out value="${item.numberOfPages}"></c:out></td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<div style="margin-left:300px;margin-top:100px" class="col w-50">
<table class="table caption-top table-bordered">
  <caption>All books</caption>
  <thead class="table-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Title</th>
      <th scope="col">Language</th>
      <th scope="col">Number of Pages</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${books}">
    <tr>
      <th scope="row"><c:out value="${item.id}"></c:out></th>
      <td><a href="/books/${item.id}"><c:out value="${item.title}"></c:out></a></td>
      <td><c:out value="${item.description}"></c:out></td>
      <td><c:out value="${item.numberOfPages}"></c:out></td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>
</div>
</body>
</html>