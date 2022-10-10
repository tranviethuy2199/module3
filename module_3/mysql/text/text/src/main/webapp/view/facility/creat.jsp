<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 10/7/2022
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Employee Management</h1>
<h2>
    <a href="/service">List All Facility</a>
</h2>
<h3>${mess}</h3>
</center>
<div align="center">
    <form method="post" action="/service?action=create">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>Service Name:</th>
                <td>
                    <input type="text" name="nameService" id="nameService" size="45" />
                </td>
            </tr>

            <tr>
                <th>Service Area:</th>
                <td>
                    <input type="text" name="area" id="area" size="30"/>
                </td>
            </tr>
            <tr>
                <th>Service cost:</th>
                <td>
                    <input type="text" name="cost" id="cost" size="30"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="phone" id="phone" size="30"/>
                </td>
            </tr>
            <tr>
                <th>Max People:</th>
                <td>
                    <input type="text" name="maxPeople" id="maxPeople" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Rent_type_id:</th>
                <td>
                    <input type="text" name="rent_type_id" id="rent_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>facility_type_id:</th>
                <td>
                    <input type="text" name="facility_type_id" id="facility_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description_other_convenience:</th>
                <td>
                    <input type="text" name="description_other_convenience" id="description_other_convenience" size="45"/>
                </td>
            </tr>
            <tr>
                <th>pool_area:</th>
                <td>
                    <input type="text" name="pool_area" id="pool_area" size="30"/>
                </td>
            </tr>
            <tr>
                <th>number_of_floors:</th>
                <td>
                    <input type="text" name="number_of_floors" id="number_of_floors" size="30"/>
                </td>
            </tr>
            <tr>
                <th>facility_free:</th>
                <td>
                    <input type="text" name="facility_free" id="facility_free" size="30"/>
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
