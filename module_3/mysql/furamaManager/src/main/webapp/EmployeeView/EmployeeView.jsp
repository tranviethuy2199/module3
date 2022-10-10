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
<p>
    <a href="/">Back to Home</a>
</p>
<table>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["employee"].getName()}</td>
        </tr>
        <tr>
            <td>Date of birth: </td>
            <td>${requestScope["employee"].getDateOfBirth()}</td>
        </tr>
        <tr>
            <td>cmnd: </td>
            <td>${requestScope["employee"].getCmnd()}</td>
        </tr>
        <tr>
            <td>Salary: </td>
            <td>${requestScope["employee"].getSalary()}</td>
        </tr>
        <tr>
            <td>Phone Number: </td>
            <td>${requestScope["employee"].getPhone_number()}</td>
        </tr>
        <tr>
            <td>email: </td>
            <td>${requestScope["employee"].getEmail()}</td>
        </tr>
        <tr>
            <td>Address: </td>
            <td>${requestScope["employee"].getAddress()}</td>
        </tr>
        <tr>
            <td>education_degree: </td>
            <td>${requestScope["employee"].getEducation_degree_id()}</td>
        </tr>
        <tr>
            <td>position_id: </td>
            <td>${requestScope["employee"].getPosition_id()}</td>
        </tr>
        <tr>
            <td>division: </td>
            <td>${requestScope["employee"].getDivision_id()}</td>
        </tr>x
    </table>
</table>
</body>
</html>
