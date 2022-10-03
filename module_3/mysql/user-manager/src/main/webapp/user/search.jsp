<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/3/2022
  Time: 2:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>search</title>
</head>
<body>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message">${requestScope["mess"]}</span>
    </c:if>
</p>
<c:if test='${requestScope["mess"] == null }'>
    <h2>Search</h2>
    <table>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>email</td>
            <td>country</td>
        </tr>
        <c:forEach items='${listUser}' var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
