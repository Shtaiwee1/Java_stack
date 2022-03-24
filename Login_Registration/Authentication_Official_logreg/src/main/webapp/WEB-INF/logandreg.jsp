<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login or Register</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="row mt-4">
<h1 style="text-align: center">Welcome!</h1>
</div>
	<div class="container-sm mt-3">
        <div class="row justify-content-center">
            <div class="col-md-4 me-5 border p-4 mt-4">
            <h3>Register</h3>
                <form:form action="/register" method="post" modelAttribute="newUser">

                    <div class="form-floating mb-3">
                    <form:input path="userName" type="text" class="form-control mt-4 " id="floatingInput" placeholder="User name" />
                    <form:label path="userName" for="floatingInput">User name</form:label>
					<form:errors path="userName" class = "my-3" style="color:red;"/>
					</div>
					<div class="form-floating mb-3">
                    <form:input path="email" type="text" class="form-control mt-4" id="floatingInput" placeholder="Email" />
                    <form:label path="email" for="floatingInput">Email</form:label>
					<form:errors path="email" class = "my-3" style="color:red;" />
					</div>
					<div class="form-floating mb-3">
                    <form:input path="password" type="password" class="form-control mt-4" id="floatingInput" placeholder="Password" />
                    <form:label path="password" for="floatingInput">Password</form:label>
                    <form:errors path="password"  style="color:red;" />
                    </div>
					<div class="form-floating mb-3">
                    <form:input path="confirm" type="password" class="form-control mt-4" id="floatingInput" placeholder="Confirm Passsword"/>
                    <form:label path="confirm" for="floatingInput">Confirm Passsword</form:label>
					<form:errors path="confirm" style="color:red;" />
					</div>
					
                    <div class="mt-4 d-flex flex-row-reverse">
					<button type="submit" class="btn btn-primary btn-sm">Register</button>
					</div>
                </form:form>
            </div>

            <div class="col-md-4 me-5 border p-4 my-4">
            <h3>Login</h3>
                <form:form action="/login" method="post" modelAttribute="newLogin">
                    
                    <div class="form-floating mb-3">
                    <form:input path="email" type="text" class="form-control mt-4" placeholder="Email" />
                    <form:label path="email" for="floatingInput">Email</form:label>
					<form:errors path="email" style="color:red;" />
					</div>
					
                    <div class="form-floating mb-3">
                    <form:input path="password" type="password" class="form-control mt-4" placeholder="Password" />
                    <form:label path="password" for="floatingInput">Password</form:label>
					<form:errors path="password" style="color:red;" />
					</div>
					
					<div class="mt-4 d-flex flex-row-reverse">
					<button type="submit" class="btn btn-primary btn-sm">Log in</button>
					</div>
                    
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>