<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customer List</title>
    <!--    bootstrap css-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Customer</h1>
<%--<p>--%>
<%--    <a href="/customer?action=create">Create new customer</a>--%>
<%--</p>--%>
<p>
    <a href="/">Back to Home</a>
</p>
<form action="/customer">
    <input type="hidden" name="action" value="search">
    <input type="text" name="search" placeholder="tìm kiếm thông tin">
    <button type="submit">enter</button>
</form>
<table class="table table-striped">
    <tr>
        <td>Id</td>
        <td>Customer_type</td>
        <td>Name</td>
        <td>Day Of Birth</td>
        <td>cmnd</td>
        <td>phone Number</td>
        <td>Email</td>
        <td>Gender</td>
        <td>Address</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <c:forEach items="${customers}" var='customer'>
        <tr>
            <td><a href="/customer?action=view&id=${customer.getId()}">${customer.getId()}</a></td>
            <td>${customer.getCustomer_type_id()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getDateOfBirth()}</td>
            <td>${customer.getGender()}</td>
            <td>${customer.getCmnd()}</td>
            <td>${customer.getPhone_number()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getAddress()}</td>
            <td><a href="/customer?action=edit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customer?action=delete&id=${customer.getId()}">delete</a></td>
            <td><a href="/customer?action=view&id=${customer.getId()}">view</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
