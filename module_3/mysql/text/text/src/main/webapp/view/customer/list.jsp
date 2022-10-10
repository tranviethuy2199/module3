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
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body style="  background: url('1000_F_294375555_tpcdo43DC1XFr6kpSv4v4bEsmcY1GgWz.jpg');">
<h1 style="text-align: center">Customer Management</h1>
<h2 style="text-align: center">
    <a class="btn btn-primary" href="/index.jsp">HOME</a>
</h2>

<h2>
    <a class="btn btn-danger" href="/customer?action=create">Add New Customer</a>
</h2>
<form action="/customer">
    <input type="hidden" name="action" value="search">
    <input type="text" name="find" placeholder="...search">
    <input class="btn btn-primary" type="submit" value="Search">
</form>
<div align="center">
    <caption><h2>List of Customer</h2></caption>
    <table id="tablecustomer" class="table table-dark table-hover" style="width:100%" border="1" cellpadding="5">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date_Of_Birth</th>
            <th>Gender</th>
            <th>ID_Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Customer_type</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.customerId}</td>
            <td><c:out value="${customer.customerName}"/></td>
            <td><c:out value="${customer.customerBirthday}"/></td>
                <%--=<td><c:out value="${customer.customerGender}"/></td>--%>
            <c:if test="${customer.customerGender ==1 }">
                <td>Nam</td>
            </c:if>
            <c:if test="${customer.customerGender == 0 }">
                <td>Nữ</td>
            </c:if>
            <td><c:out value="${customer.customerIdCard}"/></td>
            <td><c:out value="${customer.customerPhone}"/></td>
            <td><c:out value="${customer.customerEmail}"/></td>
            <td><c:out value="${customer.customerAddress}"/></td>
                <%--<td><c:out value="${customer.customerTypeId}"/></td>--%>
            <c:if test="${customer.customerTypeId==1}">
                <td>Diamond</td>
            </c:if>
            <c:if test="${customer.customerTypeId==2}">
                <td>Platinium</td>
            </c:if>
            <c:if test="${customer.customerTypeId==3}">
                <td>Gold</td>
            </c:if>
            <c:if test="${customer.customerTypeId==4}">
                <td>Silver</td>
            </c:if>
            <c:if test="${customer.customerTypeId==5}">
                <td>Member</td>
            </c:if>
            <td>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                        data-bs-target="#edit${customer.customerId}">
                    Edit
                </button>
                <div class="modal fade " id="edit${customer.customerId}" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel_edit">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn sửa <strong class="text-danger">${customer.customerName}</strong>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                </button>
                                <a href="customer?action=edit&id=${customer.customerId}" class="btn btn-danger">Edit</a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
            <td>
                <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                        data-bs-target="#delete${customer.customerId}">
                    Delete
                </button>
                <div class="modal fade " id="delete${customer.customerId}" tabindex="-1"
                     aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog ">
                        <div class="modal-content bg-dark">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel_delete">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn xóa <strong class="text-danger">${customer.customerName}</strong>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                </button>
                                <a href="customer?action=delete&id=${customer.customerId}"
                                   class="btn btn-danger">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tablecustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
</script>
</body>
</html>
