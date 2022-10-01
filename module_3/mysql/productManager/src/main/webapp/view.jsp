<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/30/2022
  Time: 1:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/product">Back to product list</a>
</p>
<table>
    <table>
        <tr>
            <td>Name: </td>
            <td>${requestScope["product"].getName()}</td>
        </tr>
        <tr>
            <td>Price: </td>
            <td>${requestScope["product"].getPrice()}</td>
        </tr>
        <tr>
            <td>Describe: </td>
            <td>${requestScope["product"].getDescribe()}</td>
        </tr>
        <tr>
            <td>Producer: </td>
            <td>${requestScope["product"].getProducer()}</td>
        </tr>
    </table>
</table>
</body>
</html>
