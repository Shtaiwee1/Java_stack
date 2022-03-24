<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Question</title>
    <!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <style>
        #wrapper {
            background-color: rgb(129, 216, 219);
            padding: 30px;
        }
        h1{
            display: inline-block;
        }
        a {
            color: white;
            font-size: 25px;
            display: inline-block;
            padding-left: 600px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <h1>Submit a Question</h1>
    <a style="position:absolute;top:30px;right:50px" class="btn btn-dark" href="/questions">Dashboard</a>
    <form action = "/questions/new/process" method = "post">
        <p>
            <c:out value = "${question}"/><br>
            Question: <br><br>
            <textarea name = "question" cols = "50" rows = "4"></textarea>
        </p>
        <p>
            <c:out value = "${tag}"/><br>
            Tags: <input type = "text" name = "tags">
        </p>
        <button type="submit" class="btn btn-dark">Add Question</button>
    </form>
</div>
</body>
</html>