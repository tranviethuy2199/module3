<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/29/2022
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      h1 {
        text-align: center;
      }
      img {
        height: 150px;
        width: 150px;
      }
      td {
        width: 200px;
        height: 200px;
      }
    </style>
  </head>
  <body>
  <table border="1px" width="50%" style="text-align: center ; margin: auto ">
    <h1>Danh sách khách hàng</h1>
    <tr>
      <td>ID</td>
      <td>Name</td>
      <td>DayOfBirth</td>
      <td>Address</td>
      <td>Picture</td>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}">
    <tr>
      <td><c:out value="${customer.getId()}"/></td>
      <td><c:out value="${customer.getName()}"/></td>
      <td><c:out value="${customer.getDayOfBirth()}"/></td>
      <td><c:out value="${customer.getAddress()}"/></td>
      <td>
        <img src="<c:out value="${customer.getPicture()}"/>">
      </td>
    </tr>
    </c:forEach>
  </table>
  </body>
</html>
