<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/7/2022
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contract list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <style>
        body {
            background-image: url(https://img.wallpapersafari.com/desktop/1600/900/22/47/iU4Gez.jpg);
        }
        table {
            border: solid 3px;
        }
        a {
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>CONTRACT LIST</h2>
<p ><a style="color: white" href="/"> Back to HOME</a></p>
<table id="contractTable" class="table table-light table-striped table-bordered">
    <thead>
    <tr class="table-dark text-light">
        <th class="text-center"><i class="fa-solid fa-dog"></i></th>
        <th>Facility</th>
        <th>Employee</th>
        <th>Customer</th>
        <th>Start day</th>
        <th>End day</th>
        <th>Deposit</th>
        <th>Total money</th>
        <th style="text-align: center">Attach facility</th>
    </tr>
    </thead>

    <tbody>
    <%--    <c:forEach varStatus="status" var="contract" items="${contractList}">--%>
    <tr>
        <td class="text-center">${status.count}</td>
        <%--            <c:forEach var="facility" items="${facilityList}">--%>
        <%--                <c:if test="${facility.facilityId == contract.facilityId}">--%>
        <td>${"test"}</td>
        <%--                </c:if>--%>
        <%--            </c:forEach>--%>
        <%--            <c:forEach var="employee" items="${employeeList}">--%>
        <%--                <c:if test="${employee.employeeId == contract.employeeId}">--%>
        <td>${"test"}</td>
        <%--                </c:if>--%>
        <%--            </c:forEach>--%>
        <%--            <c:forEach var="customer" items="${customerList}">--%>
        <%--                <c:if test="${customer.customerId == contract.customerId}">--%>
        <td>${"test"}</td>
        <%--                </c:if>--%>
        <%--            </c:forEach>--%>
        <%--            <td>${contract.startDate}</td>--%>
        <td>${"test"}</td>
        <%--            <td>${contract.endDate}</td>--%>
        <td>${"test"}</td>
        <%--            <td>₫${String.format("%.0f", contract.deposit)}</td>--%>
        <td>${"test"}</td>
        <%--            <td>₫${String.format("%.0f", contract.totalMoney)}</td>--%>
        <td>${"test"}</td>
        <td class="text-center">
            <%--                <a href="/contract?action=add&id=${contract.contractId}" data-bs-toggle="modal"--%>
            <a href="#" data-bs-toggle="modal"
               data-bs-target="#addAttachFacility">
                <%--                   onclick="addAttachFacility('${contract.getContractId()}')">--%>
                <button class="btn btn-primary btn-outline-secondary btn-sm">
                    <span class="fa-solid fa-plus text-light h6 m-auto">+</span>
                </button>
            </a>
            <%--                <a href="/contract?action=show&id=${contract.contractId}" data-bs-toggle="modal"--%>
            <a href="/" data-bs-toggle="modal"
               data-bs-target="#showAttachFacility">
                <%--                   onclick="showAttachFacility('${contract.getContractId()}')">--%>
                <button class="btn btn-primary btn-outline-secondary btn-sm ms-2">
                    <span class="text-light m-auto">Attach facility list</span>
                </button>
            </a>
        </td>
    </tr>
    <%--    </c:forEach>--%>
    </tbody>
</table>
</body>
</html>
