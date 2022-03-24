<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Queries and Joins</title>
    <link rel = "stylesheet" href = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <style>
        #wrapper {
            background-color: lightgrey;
        }
        #main {
            padding: 25px;
            padding-left: 150px;
        }
        h3 {
            padding: 15px;
            width: 1000px;
        }
        table {
            border: 1px solid black;
            border-collapse: collapse;
            margin-top: 30px;
            width: 1000px;
        }
        th {
            text-align: left;
            border: 1px solid black;
            border-collapse: collapse;
            padding: 5px;
            padding-left: 10px;
            padding-right: 100px;
            background-color: rgb(116, 162, 237);
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
    <div id = "main">
        <h3>Problem #1: What query would you run to get all the countries that speak Slovene?
            Your query should return the name of the country, language, and language percentage.
            Your query should arrange the result by language percentage in descending order.</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Language</th>
                <th>Percentage</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td>${t[2]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #2: What query would you run to display the total number of cities for each country?
            Your query should return the name of the country and the total number of cities.
            Your query should arrange the result by the number of cities in descending order.</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Cities</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table2}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #3: What query would you run to get all the cities in Mexico with a population of
            greater than 500,000? Your query should arrange the result by population in descending order.</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Population</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table3}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #4: What query would you run to get all languages in each country with a percentage
            greater than 89%? Your query should arrange the result by percentage in descending order.</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Language</th>
                <th>Percentage</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table4}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td>${t[2]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #5: What query would you run to get all the countries with Surface Area
            below 501 and Population greater than 100,000?</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Surface Area</th>
                <th>Population</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table5}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td>${t[2]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #6: What query would you run to get countries with only Constitutional
            Monarchy with a surface area greater than 200 and a life expectancy greater
            than 75 years?</h3>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Government Form</th>
                <th>Surface Area</th>
                <th>Life Expectancy</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table6}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td>${t[2]}</td>
                    <td>${t[3]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #7: What query would you run to get all the cities of Argentina inside the
            Buenos Aires district and have the population greater than 500,000? The query should
            return the Country Name, City Name, District, and Population.</h3>
        <table>
            <thead>
            <tr>
                <th>Country Name</th>
                <th>City Name</th>
                <th>District</th>
                <th>Population</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table7}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                    <td>${t[2]}</td>
                    <td>${t[3]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <h3>Problem #8: What query would you run to summarize the number of countries in each region?
            The query should display the name of the region and the number of countries.
            Also, the query should arrange the result by the number of countries in descending order.</h3>
        <table>
            <thead>
            <tr>
                <th>Region</th>
                <th>Countries</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${table8}" var = "t">
                <tr>
                    <td>${t[0]}</td>
                    <td>${t[1]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>