<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
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
<body>
<div id="container">
    <div id="header">
        <h2 id="counter">Your Gold:<c:out value="${gold}"></c:out><br>  <a class="btn btn-primary button-margin" href="/reset">Reset!</a></h2>
    </div>
    <div style="display:flex" id="forms">
        <form style="text-align:center;margin-left: 90px;border:2px solid black;padding:20px" class="form" action="/process" method="post">
            <h2 id="location">Farm</h2>
            <h3 id="desc">(earns 10-20 golds)</h3>
            <input type="hidden" name="place" value="farm">
            <button type="submit" class="btn btn-warning">Find Gold!</button>
        </form>
        <form style="text-align:center;margin-left: 90px;border:2px solid black;padding:20px" class="form" action="/process" method="post">
            <h2 id="location">Cave</h2>
            
            <h3 id="desc">(earns 5-10 golds)</h3>
            <input type="hidden" name="place" value="cave">
            <a href='/process_money'><button type="submit" class="btn btn-warning">Find Gold!</button></a>
        </form>
        <form style="text-align:center;margin-left: 90px;border:2px solid black;padding:20px" class="form" action="/process" method="post">
            <h2 id="location">House</h2>
            
            <h3 id="desc">(earns 2-5 golds)</h3>
            <input type="hidden" name="place" value="house">
            <a href='/process_money'><button type="submit" class="btn btn-warning">Find Gold!</button></a>
        </form>
        <form style="text-align:center;margin-left: 90px;border:2px solid black;padding:20px" class="form" action="/process" method="post">
            <h2 id="location">Quest</h2>
            
            <h3 id="desc">(earns/takes 0-50 golds)</h3>
            <input type="hidden" name="place" value="quest">
            <a href='/process_money'><button type="submit" class="btn btn-warning">Find Gold!</button></a>
        </form>
        <form style="margin-right:50px;text-align:center;margin-left: 90px;border:2px solid black;padding:20px" class="form" action="/process" method="post">
            <h2 id="location">Spa</h2>
            <h3 id="desc">(takes 5-20 golds)</h3>
            <input type="hidden" name="place" value="spa">
            <a href='/process_money'><button type="submit" class="btn btn-success">Take it easy!</button></a>
        </form>
	</div>
	<h1 style="margin-top:100px;margin-left:100px;margin-bottom:40px">Activities:</h1>
	<div class="activities" id="output">
        <ul>
            <% if(session.getAttribute("activities") != null | session.getAttribute("activities") == null){ %>
            <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); %>
            <% for(int i = 0; i < activities.size(); i++) { %>
            <% if(activities.get(i).contains("lost") | activities.get(i).contains("cost")) { %>
            <li style = "color: red;"><%= activities.get(i) %></li>
            <% } else { %>
            <li style = "color: green;"><%= activities.get(i) %></li>
            <% } %>
            <% } %>
            <% } %>
        </ul>
    </div>
</div>
</body>
</html>