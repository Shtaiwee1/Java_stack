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

<p>Project:<c:out value="${project.title}"></c:out></p>
<p>Project Lead:<c:out value="${project.teamLead.firstName}"></c:out>   </p>


<form:form action="/projects/${project.id}/tasks" method="post" modelAttribute="task">
		<div class="mb-3">
			<form:errors class="text-danger" path="ticket" />
			<form:textarea type="text" class="form-control" id="ticket" path="ticket" placeholder="Ticket" ></form:textarea>
		</div>
		<button type="submit" class="btn btn-success float-end">Submit</button>
	</form:form>
	
	
	<c:forEach var="task" items="${project.tasks}">
	<div>
	<p>Added by <span><c:out value="${task.user.firstName}"></c:out></span> at <span><c:out value="${task.createdAt}"></c:out></span></p>
	
	<p><c:out value="${task.ticket}"></c:out></p>
	
	
	</div>
	
	</c:forEach>
</body>
</html>