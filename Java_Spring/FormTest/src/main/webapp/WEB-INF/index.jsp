<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h3>Login</h3>
    <form action='/login' method='GET'>
	<label>Email:</label>
    	<input type="text" name='email'>
	<label>Password:</label>
    	<input type='text' name='password'>
    	<input type='submit' value='login'>
    </form>

</body>
</html>