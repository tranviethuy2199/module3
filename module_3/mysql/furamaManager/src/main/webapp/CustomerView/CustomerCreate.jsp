<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/30/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creat new Customer</title>
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
<h1>Creat new Cutomer</h1>
<p>
    <c:if test="${requestScope['message'] !=null }" >
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<form action="/customer?action=create" method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table-striped">
            <tr>
                <td>customer_type_id: </td>
                <td><input type="text" name="customer_type_id" id="customer_type_id" value="${customer.getCustomer_type_id()}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${customer.getName()}"></td>
            </tr>
            <tr>
                <td>Day of birth: </td>
                <td><input type="text" name="date_of_birth" id="date_of_birth" value="${customer.getDayOfBirth()}"></td>
            </tr>
            <tr>
                <td>gender: </td>
                <td><input type="text" name="gender" id="gender" value="${customer.getGender()}"></td>
            </tr>
            <tr>
                <td>Cmnd: </td>
                <td><input type="text" name="id_card" id="id_card" value="${customer.getCmnd()}"></td>
            </tr>
            <tr>
                <td>phone_number: </td>
                <td><input type="text" name="phone_number" id="phone_number" value="${customer.getPhone_Number()}"></td>
            </tr>
            <tr>
                <td>email: </td>
                <td><input type="text" name="email" id="email" value="${customer.getEmail()}"></td>
            </tr>

            <tr>
                <td>address: </td>
                <td><input type="text" name="address" id="address" value="${customer.getAddress()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
            <tr>
                <p>
                    <a href="/customer">Back to customer list</a>
                </p>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
