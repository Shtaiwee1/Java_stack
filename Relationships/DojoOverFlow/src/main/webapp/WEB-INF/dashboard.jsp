<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Questions Dashboard</title>
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
        h1 {
            text-align: center;
        }
        
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin: 20px;
            margin-left: 150px;
            margin-bottom: 30px;
        }
        th {
            text-align: left;
            border: 1px solid black;
            border-collapse: collapse;
            color: white;
            padding: 5px;
            padding-left: 10px;
            padding-right: 400px;
            background-color: blue;
            font-size: 18px;
        }
        tr td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 10px;
            background-color: rgb(237, 241, 248);
            font-size: 18px;
        }
    </style>
</head>
<body>
<div id = "wrapper">
    <div id = "top">
        <h1>Questions Dashboard</h1>
        <h4><a class="btn btn-warning" href="/questions/new">Add a new question</a></h4>
        
    </div>
    <table>
        <thead>
        <tr>
            <th>Questions</th>
            <th>Tags</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var = "q"  items = "${questions}">
            <tr>
                <td><a style="text-decoration: none" href = "/questions/${q.id}">${q.question}</a></td>
                <td><c:forEach  var = "t"  items = "${q.tags}">
                    ${t.subject},
                </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>