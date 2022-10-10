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
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
</head>
<body style="  background: url('1000_F_294375555_tpcdo43DC1XFr6kpSv4v4bEsmcY1GgWz.jpg');">
<h1 style="text-align: center">User Management</h1>
<h2 style="text-align: center">
    <a class="btn btn-primary" href="/index.jsp">HOME</a>
</h2>

<h2>
    <a class="btn btn-danger" href="/employee?action=create">Add New Employee</a>
</h2>
<form action="/employee">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="...search">
    <input class="btn btn-primary" type="submit" value="Search">
</form>
<div align="center">
    <caption><h2>List of Employee</h2></caption>
    <table id="tableemployee" class="table table-dark table-hover" style="width:100%" border="1" cellpadding="5">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Date_Of_Birth</th>
            <th>ID_Card</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Education_Degree</th>
            <th>Position</th>
            <th>Division</th>
            <th>Salary</th>
            <th>Action</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employeeList}">
            <tr>
                <td><c:out value="${employee.employeeId}"/></td>
                <td><c:out value="${employee.employeeName}"/></td>
                <td><c:out value="${employee.employeeBirthday}"/></td>
                <td><c:out value="${employee.employeeIdCard}"/></td>
                <td><c:out value="${employee.employeePhone}"/></td>
                <td><c:out value="${employee.employeeEmail}"/></td>
                <td><c:out value="${employee.employeeAddress}"/></td>
                    <%--<td><c:out value="${employee.educationDegreeId}"/></td>--%>

                <c:if test="${employee.educationDegreeId == 1}">
                    <td>Trung Cấp</td>
                </c:if>
                <c:if test="${employee.educationDegreeId == 2}">
                    <td>Cao Đẳng</td>
                </c:if>
                <c:if test="${employee.educationDegreeId == 3}">
                    <td>Đại Học</td>
                </c:if>
                <c:if test="${employee.educationDegreeId == 4}">
                    <td>Sau Đại Học</td>
                </c:if>
                    <%--                <td><c:out value="${employee.positionId}"/></td>--%>
                <c:if test="${employee.positionId==1}">
                    <td>Quản Lý</td>
                </c:if>
                <c:if test="${employee.positionId==2}">
                    <td>Nhân Viên</td>
                </c:if>
                    <%--                <td><c:out value="${employee.divisionId}"/></td>--%>
                <c:if test="${employee.divisionId==1}">
                    <td>
                        Sale-Marketing
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==2}">
                    <td>
                        Hành Chính
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==3}">
                    <td>
                        Phục Vụ
                    </td>
                </c:if>
                <c:if test="${employee.divisionId==4}">
                    <td>
                        Quản Lý
                    </td>
                </c:if>

                <td>
                    <c:out value="${employee.employeeSalary}"/>
                </td>

                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#edit${employee.employeeId}">
                        Edit
                    </button>
                    <div class="modal fade " id="edit${employee.employeeId}" tabindex="-1"
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
                                    Bạn có muốn sửa <strong class="text-danger">${employee.employeeName}</strong>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <a href="employee?action=edit&id=${employee.employeeId}"
                                       class="btn btn-danger">Edit</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-bs-toggle="modal"
                            data-bs-target="#delete${employee.employeeId}">
                        Delete
                    </button>
                    <div class="modal fade " id="delete${employee.employeeId}" tabindex="-1"
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
                                    Bạn có muốn xóa <strong class="text-danger">${employee.employeeName}</strong>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close
                                    </button>
                                    <a href="employee?action=delete&id=${employee.employeeId}" class="btn btn-danger">Delete</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableemployee').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });
</script>
</body>
</html>
