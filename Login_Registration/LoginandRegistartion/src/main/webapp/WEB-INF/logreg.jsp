<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<%@ page isErrorPage="true" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login or Register</title>
    <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div id = "wrapper">
    <h1>Join our community! </h1>
    <div id = "register">
        <h2>Register here!</h2>

        <form:form action = "/register" method = "post"  modelAttribute = "user">
            <p>
                <form:label path = "firstName">First Name:</form:label>
                <form:errors path = "firstName"/><br>
                <form:input path = "firstName"/>
            </p>
            <p>
                <form:label path = "lastName">Last Name: </form:label>
                <form:errors path = "lastName"/><br>
                <form:input path = "lastName"/>
            </p>
            <p>
                <form:label path = "email">Email:</form:label>
                <form:errors path = "email"/><br>
                <form:input path = "email"/>
            </p>
            <p>
                <form:label path = "password">
                <ul>
                <li>Must be at least 6 characters long</li>
                <li>no white spaces</li>
                <li>Contains an uppercase and a lowercase letter</li>
                <li>Contains a number</li>
                </ul>
                    Password:</form:label>
                <form:errors path = "password"/><br>
                <form:password path = "password"/>
            </p>
            <p>
                <form:label path = "passwordConfirmation">Password Confirmation:</form:label>
                <form:errors path = "passwordConfirmation"/><br>
                <form:password path = "passwordConfirmation"/>
            </p>
            <input type = "submit" value = "Register!"/>
        </form:form>
    </div>

    <div id = "login">
        <h2>Login here!</h2>
        <p><c:out value = "${error}" /></p>
        <form action = "/login" method = "post" >
            <p>
                <label for = "email">Email</label><br>
                <input type = "text" id = "email" name = "email"/>
            </p>
            <p>
                <label for = "password">Password</label><br>
                <input type = "password" id = "password" name = "password"/>
            </p>
            <input type = "submit" value = "Login!"/>
        </form>
    </div>
</div>
</body>
</html>