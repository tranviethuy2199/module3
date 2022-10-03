<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Employee</title>
</head>
<body>
<h1>Employee details</h1>
<p>
    <a href="/employee">Back to employee list</a>
</p>
<table>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["employee"].getName()}</td>
        </tr>
        <tr>
            <td>Day of birth: </td>
            <td>${requestScope["employee"].getDayOfBirth()}</td>
        </tr>
        <tr>
            <td>cmnd: </td>
            <td>${requestScope["employee"].getCmnd()}</td>
        </tr>
        <tr>
            <td>email: </td>
            <td>${requestScope["employee"].getEmail()}</td>
        </tr>
    </table>
</table>
</body>
</html>
