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
    <title>View Customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<table>
    <tr>
        <td>customer_type_id:</td>
        <td>${requestScope["customer"].getCustomer_type_id()}</td>
    </tr>
    <tr>
        <td>Name:</td>
        <td>${requestScope["customer"].getName()}</td>
    </tr>
    <tr>
        <td>Day of birth:</td>
        <td>${requestScope["customer"].getDateOfBirth()}</td>
    </tr>
    <tr>
        <td>gender:</td>
        <td>${requestScope["customer"].getGender()}</td>
    </tr>
    <tr>
        <td>cmnd:</td>
        <td>${requestScope["customer"].getCmnd()}</td>
    </tr>
    <tr>
        <td>phone_number:</td>
        <td>${requestScope["customer"].getPhone_number()}</td>
    </tr>
    <tr>
        <td>email:</td>
        <td>${requestScope["customer"].getEmail()}</td>
    </tr>
    <tr>
        <td>address:</td>
        <td>${requestScope["customer"].getAddress()}</td>
    </tr>
</table>
</body>
</html>
