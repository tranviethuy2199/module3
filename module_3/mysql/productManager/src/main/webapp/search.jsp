<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/30/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Product</title>
</head>
<body>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<c:if test='${requestScope["mess"] == null}'>
    <h1>Search Product</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Price</td>
            <td>Describe</td>
            <td>Producer</td>
        </tr>
        <c:forEach items='${products}' var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescribe()}</td>
                <td>${product.getProducer()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
