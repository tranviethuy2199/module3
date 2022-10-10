<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/7/2022
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Customer Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customer">List All Customer</a>
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
                    Edit Customer
                </h2>
            </caption>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45" value="${customer.customerName}"/>
                </td>
            </tr>

            <tr>
                <th>Customer Customer Date Of Birth:</th>
                <td>
                    <input type="text" name="dateOfBirth" id="date" size="45" value="${customer.customerBirthday}"/>
                </td>
            </tr>
            <tr>
                <th>Customer gender:</th>
                <td>
                    <c:if test="${customer.customerGender==0}">
                        <input name="gender" type="radio" value="1">Nam
                        <input name="gender" type="radio" value="0" checked>Nữ
                    </c:if>
                    <c:if test="${customer.customerGender==1}">
                        <input name="gender" type="radio" value="1" checked>Nam
                        <input name="gender" type="radio" value="0">Nữ
                    </c:if>
                </td>
            </tr>
            <tr>
                <th>Customer Customer ID Card:</th>
                <td>
                    <input type="text" name="idCard" id="idCard" size="45" value="${customer.customerIdCard}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="45" value="${customer.customerPhone}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45" value="${customer.customerEmail}"/>
                </td>
            </tr>

            <tr>
                <th>Customer address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45" value="${customer.customerAddress}"/>
                </td>
            </tr>
            <tr>
                <th>Customer Type:</th>
                <td>
                    <c:if test="${customer.customerTypeId == 1}">
                        <select name="customerType">
                            <option value="1" selected>Diamond</option>
                            <option value="2">Platinium</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </c:if>
                    <c:if test="${customer.customerTypeId == 2}">
                        <select name="customerType">
                            <option value="1" >Diamond</option>
                            <option value="2" selected>Platinium</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </c:if>
                    <c:if test="${customer.customerTypeId == 3}">
                        <select name="customerType">
                            <option value="1" >Diamond</option>
                            <option value="2">Platinium</option>
                            <option value="3" selected>Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </c:if>
                    <c:if test="${customer.customerTypeId == 4}">
                        <select name="customerType">
                            <option value="1" >Diamond</option>
                            <option value="2">Platinium</option>
                            <option value="3">Gold</option>
                            <option value="4"selected>Silver</option>
                            <option value="5">Member</option>
                        </select>
                    </c:if>
                    <c:if test="${customer.customerTypeId == 5}">
                        <select name="customerType">
                            <option value="1" >Diamond</option>
                            <option value="2">Platinium</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5"selected>Member</option>
                        </select>
                    </c:if>
                </td>
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
