<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Deleting employee</title>
</head>
<body>
<h1>Delete employee</h1>
<p>
    <a href="/employee">Back to employee list</a>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Employee information</legend>
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
            <tr>
                <td>gender: </td>
                <td>${requestScope["employee"].getGender()}</td>
            </tr>
            <tr>
                <td>education_degree: </td>
                <td>${requestScope["employee"].getEducation_degree()}</td>
            </tr>
            <tr>
                <td>position_id: </td>
                <td>${requestScope["employee"].getPosition_id()}</td>
            </tr>
            <tr>
                <td>division: </td>
                <td>${requestScope["employee"].getDivision()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete employee"></td>
                <td><a href="/employee">Back to employee list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
