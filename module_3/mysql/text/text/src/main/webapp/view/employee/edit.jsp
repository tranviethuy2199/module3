<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/7/2022
  Time: 11:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Employee Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employee">List All Employee</a>
    </h2>
    <p>
        <c:if test="${mess != null}">
            <span>${mess}</span>
        </c:if>
    </p>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>
            <%--            <c:if test="${user != null}">--%>
            <%--                <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>--%>
            <%--            </c:if>--%>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${employee.employeeName}">
                </td>
            </tr>
            <tr>
                <th>Employee Employee Date Of Birth:</th>
                <td>
                    <input type="text" name="date" id="date" size="45" value="${employee.employeeBirthday}">
                </td>
            </tr>
            <tr>
                <th>Employee Employee ID Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45" value="${employee.employeeIdCard}">
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45" value="${employee.employeePhone}">
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${employee.employeeEmail}">
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${employee.employeeAddress}">
                </td>
            </tr>
            <tr>
                <th>Employee Education_Degree:</th>
                <c:if test="${employee.educationDegreeId==1}">
                    <td>
                        <select name="education">
                            <option value="1" selected>Trung Cấp</option>
                            <option value="2">Cao Đẳng</option>
                            <option value="3">Đại Học</option>
                            <option value="4">Sau Đại Học</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.educationDegreeId==2}">
                    <td>
                        <select name="education">
                            <option value="1" >Trung Cấp</option>
                            <option value="2" selected>Cao Đẳng</option>
                            <option value="3">Đại Học</option>
                            <option value="4">Sau Đại Học</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.educationDegreeId==3}">
                    <td>
                        <select name="education">
                            <option value="1" >Trung Cấp</option>
                            <option value="2" >Cao Đẳng</option>
                            <option value="3" selected>Đại Học</option>
                            <option value="4">Sau Đại Học</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.educationDegreeId==4}">
                    <td>
                        <select name="education">
                            <option value="1" selected>Trung Cấp</option>
                            <option value="2">Cao Đẳng</option>
                            <option value="3" >Đại Học</option>
                            <option value="4" selected>Sau Đại Học</option>
                        </select>
                    </td>
                </c:if>
            </tr>
            <tr>
                <th>Employee Position:</th>
                <c:if test="${employee.positionId==1}">
                    <td>
                        <select name="position">
                            <option value="1" selected>Quản Lý</option>
                            <option value="2">Nhân Viên</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.positionId==2}">
                    <td>
                        <select name="position">
                            <option value="1" >Quản Lý</option>
                            <option value="2" selected>Nhân Viên</option>
                        </select>
                    </td>
                </c:if>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="salary" id="salary" size="45" value="${employee.employeeSalary}">
                </td>
            </tr>
            <tr>
                <th>Employee Division:</th>
                <c:if test="${employee.divisionId==1}">
                    <td>
                        <select name="division">
                            <option value="1" selected>Sale-Marketing</option>
                            <option value="2">Hành Chính</option>
                            <option value="3">Phục Vụ</option>
                            <option value="4">Quản Lý</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==2}">
                    <td>
                        <select name="division">
                            <option value="1" >Sale-Marketing</option>
                            <option value="2" selected>Hành Chính</option>
                            <option value="3">Phục Vụ</option>
                            <option value="4">Quản Lý</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==3}">
                    <td>
                        <select name="division">
                            <option value="1" >Sale-Marketing</option>
                            <option value="2" >Hành Chính</option>
                            <option value="3" selected>Phục Vụ</option>
                            <option value="4">Quản Lý</option>
                        </select>
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==4}">
                    <td>
                        <select name="division">
                            <option value="1" >Sale-Marketing</option>
                            <option value="2">Hành Chính</option>
                            <option value="3" >Phục Vụ</option>
                            <option value="4" selected>Quản Lý</option>
                        </select>
                    </td>
                </c:if>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
