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
<!-- <link rel="stylesheet" type="text/css" href="css/fruity.css"> -->
</head>
<body >
<h1 style="text-align:center;margin-bottom:55px; margin-top:50px">Send an Omikuji!</h1>
<form action="/omikuji/process" method="post" style="border:2px solid grey;padding:50px 80px;" class="bd-example w-50 col-md-8 offset-md-3">
<div class=" mb-3">
   <label for="exampleFormControlTextarea1" class="form-label">Pick any number from 5 to 25</label>
  <select name="number" class="form-select" id="inputGroupSelect01">
    <option selected>0</option>
    <%for(int i=5 ; i<26 ; i++){ %>
    <option value="<%= i %>"><%= i %></option>
    <%} %>
    
    
  </select>
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Enter the name of any city</label>
  <input name="city" type="text" class="form-control"  placeholder="Nairobi">
</div>
<div class="mb-3">

  <label for="exampleFormControlInput1" class="form-label">Enter the name of any real person</label>
  <input name="person" type="text" class="form-control"  placeholder="Bob Dylan">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Enter proffesional endeavor or hobby:</label>
  <input name="hobby" type="text" class="form-control"  placeholder="Selling origamis">
</div>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Enter any type of living thing</label>
  <input name="thing" type="text" class="form-control"  placeholder="ferret">
</div>
<div class="mb-3">
  <label for="exampleFormControlTextarea1" class="form-label">Say something nice to someone</label>
  <textarea name="saying" class="form-control"  rows="3" placeholder="You do not realize how happy you make others"></textarea>
</div>

<p>Send and show a friend</p>
<input class="btn btn-primary" type="submit" value="Send">

</form>

</body>
</html>