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
<p>
    <a href="/customer?action=CustomerCreate">Create new customer</a>
</p>
<form action="/customer?action=CustomerSearch" method="post">
    <input type="text" name="search" placeholder="tìm kiếm sản phẩm">
    <button type="submit">enter</button>
</form>
<table class="table table-striped">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Day Of Birth</td>
        <td>cmnd</td>
        <td>Email</td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <c:forEach items='${requestScope["customers"]}' var='product'>
        <tr>
            <td><a href="/customer?action=CustomerView&id=${customer.getId()}">${customer.getId()}</a></td>
            <td>${customer.getName()}</td>
            <td>${customer.getDayOfBirth()}</td>
            <td>${customer.getCmnd()}</td>
            <td>${customer.getEmail()}</td>
            <td><a href="/customer?action=CustomerEdit&id=${customer.getId()}">edit</a></td>
            <td><a href="/customer?action=CustomerDelete&id=${customer.getId()}">delete</a></td>
            <td><a href="/customer?action=CustomerView&id=${customer.getId()}">view</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
