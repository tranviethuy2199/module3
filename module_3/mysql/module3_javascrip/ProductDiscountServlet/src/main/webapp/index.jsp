<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/26/2022
  Time: 9:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<div class="content">
    <h1>Product Discount Calculator</h1>
    <form action="/result.jsp" method="post">
        <div class="content">
            <div class="data">
                <label>Product Description</label>
                <input type="text" name="Description">
                <br>
                <label>Price</label>
                <input type="text" name="Price">
                <br>
                <label>Discount Percent</label>
                <input type="text" name="Discount Percent">
            </div>
            <div id="submit">
                <input type="submit" value="Discount Product">
            </div>
        </div>
    </form>
</div>
</body>
</html>
