<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creat new Employee</title>
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
<h1>Creat new Employee</h1>
<p>
    <c:if test="${requestScope['message'] !=null }" >
        <span class="message">${requestScope['message']}</span>
    </c:if>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<form action="/employee?action=create" method="post">
    <fieldset>
        <legend>Employee information</legend>
        <table class="table table-striped">
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Day of birth: </td>
                <td><input type="text" name="date_of_birth" id="dateOfBirth"></td>
            </tr>
            <tr>
                <td>cmnd: </td>
                <td><input type="text" name="id_card" id="cmnd"></td>
            </tr>
            <tr>
                <td>salary: </td>
                <td><input type="text" name="salary" id="salary"></td>
            </tr>
            <tr>
                <td>phone number: </td>
                <td><input type="text" name="phone_number" id="phone_number"></td>
            </tr>
            <tr>
                <td>email </td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
            <tr>
                <td>Address </td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <td>education_degree </td>
                <td><input type="text" name="education_degree_id" id="education_degree_id"></td>
            </tr>
            <tr>
                <td>position_id </td>
                <td><input type="text" name="position_id" id="position_id"></td>
            </tr>
            <tr>
                <td>division </td>
                <td><input type="text" name="division_id" id="division"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create employee"></td>
            </tr>
            <tr>
                <p>
                    <a href="/employee">Back to Employee list</a>
                </p>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
