<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
<p>
    <c:if test='${requestScope["mess"] != null}'>
        <span class="message">${requestScope["mess"]}</span>
    </c:if>
</p>
<p>
    <a href="/employee">Back to employee list</a>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<c:if test='${requestScope["mess"] == null}'>
    <h1>Search Employee</h1>
    <table border="1">
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Day Of Birth</td>
            <td>cmnd</td>
            <td>Email</td>
            <td>Gender</td>
            <td>Education</td>
            <td>Position</td>
            <td>Division</td>
        </tr>
        <c:forEach items='${employee}' var="employee">
            <tr>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getDayOfBirth()}</td>
                <td>${employee.getCmnd()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getGender()}</td>
                <td>${employee.getEducation_degree()}</td>
                <td>${employee.getPosition_id()}</td>
                <td>${employee.getDivision()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
