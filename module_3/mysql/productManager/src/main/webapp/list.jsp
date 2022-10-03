<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/30/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Product List</title>
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
<h1>Product</h1>
<p>
    <a href="/product?action=create">Create new Product</a>
</p>
<form action="/product?action=search" method="post">
        <input type="text" name="search" placeholder="tìm kiếm sản phẩm">
        <button type="submit">enter</button>
</form>
<table class="table table-striped">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td>describe</td>
        <td>producer</td>
        <td></td>
        <td></td>
        <td></td>

    </tr>
    <c:forEach items='${requestScope["products"]}' var='product'>
        <tr>
            <td><a href="/product?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescribe()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
            <td><a href="/product?action=view&id=${product.getId()}">view</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
