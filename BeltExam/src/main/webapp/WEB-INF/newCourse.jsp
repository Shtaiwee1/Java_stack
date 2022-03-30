<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isErrorPage="true" %>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<title>Add a new Course</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">

		<div class="row my-5">
			<div class="col-6 offset-3">
				<div class="row mb-5">
					<div class="col">
						<h3>Create a Course</h3>

					</div>
					<div class="col text-end">
						<a href="/classes">Back to dasboard</a>
					</div>
				</div>
				<div class="row">
					<div class="col text-start">

						<form:form action="/process/new" method="post"
							modelAttribute="newClass">
							<div class="form-floating mb-3">
								
								<form:input type="text" class="form-control" id="name"
									path="name" placeholder="name" />
									<form:label path="name" for="floatingInput">name</form:label>
									<form:errors class="text-danger" path="name" />
							</div>
							<div class="form-floating mb-3">
								
								<form:input class="form-control" type="text" id="day"
									path="day" placeholder="Day of Week" rows="3"></form:input>
									<form:label path="day" for="floatingInput">Day of Week</form:label>
									<form:errors class="text-danger" path="day" />
							</div>
							<div class="form-floating mb-3">
								
								<form:input class="form-control" type="number" id="price"
									path="price" placeholder="Price" rows="3" />
									
									
									<form:label path="price" for="floatingInput">price</form:label>
									<form:errors class="text-danger" path="price" />
							</div>
							
							<div class="form-floating mb-3">
								
								<form:textarea class="form-control" id="description"
									path="description" placeholder="Description" rows="3"></form:textarea>
									<form:label path="description" for="floatingInput">description</form:label>
									<form:errors class="text-danger" path="description" />
							</div>

							
							<button type="submit" class="btn btn-success float-end ms-2">Submit</button>
							<a href="/classes" class="btn btn-danger float-end">Cancel</a>
						</form:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
</html>