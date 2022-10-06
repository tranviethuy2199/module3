<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/1/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit employee</title>
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
<h1>Edit employee</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/employee">Back to employee list</a>
</p>
<p>
    <a href="/">Back to Home</a>
</p>
<form action="/employee?action=edit">
    <fieldset>
        <legend>employee information</legend>
        <table class="table table-striped">
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${employee.getName()}"></td>
            </tr>
            <tr>
                <td>Day of birth: </td>
                <td><input type="text" name="dayOfBirth" id="dayOfBirth" value="${employee.getDayOfBirth()}"></td>
            </tr>
            <tr>
                <td>Cmnd: </td>
                <td><input type="text" name="cmnd" id="cmnd" value="${employee.getCmnd()}"></td>
            </tr>
            <tr>
                <td>email: </td>
                <td><input type="text" name="email" id="email" value="${employee.getEmail()}"></td>
            </tr>
            <tr>
                <td>gender: </td>
                <td><input type="text" name="email" id="gender" value="${employee.getGender()}"></td>
            </tr>
            <tr>
                <td>education_degree: </td>
                <td><input type="text" name="email" id="education_degree" value="${employee.getEducation_degree()}"></td>
            </tr>
            <tr>
                <td>position_id: </td>
                <td><input type="text" name="email" id="position_id" value="${employee.getPosition_id()}"></td>
            </tr>
            <tr>
                <td>division: </td>
                <td><input type="text" name="email" id="division" value="${employee.getDivision()}"></td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update employee"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
