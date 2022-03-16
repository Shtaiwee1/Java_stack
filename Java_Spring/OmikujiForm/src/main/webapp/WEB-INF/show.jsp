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
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
</head>
<body style="text-align:center">
<h1>Here's Your Omikuji</h1>
<div class="omikuji container my-5 w-50">
		<div class="row">
			<div class="col-4 offset-4">
				

			</div>
		</div>
		<div class="row mt-5">
			<div class="col-8 offset-2" id="message">
				<p style="font-weight:500"  class="display-3 ">
					In
					<c:out value="${number}" />
					years, you will live in
					<c:out value="${city}" />
					with
					<c:out value="${person}" />
					as your roommate,
					<c:out value="${hobby}" />
					for a living. The next time you see a
					<c:out value="${thing}" />
					, you will have good luck. Also,
					<c:out value="${saying}" />
				</p>

			</div>
		</div>
		<div class="row">
			<div class="col-4 offset-4 text-center">
				
			</div>
		</div>
		
	</div>
	<a class="back" href="/omikuji">Go Back</a>
</body>
</html>