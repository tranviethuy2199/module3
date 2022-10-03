<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Deleting customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["customer"].getName()}</td>
            </tr>
            <tr>
                <td>Day of birth: </td>
                <td>${requestScope["customer"].getDayOfBirth()}</td>
            </tr>
            <tr>
                <td>cmnd: </td>
                <td>${requestScope["customer"].getCmnd()}</td>
            </tr>
            <tr>
                <td>email: </td>
                <td>${requestScope["customer"].getEmail()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customer">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
