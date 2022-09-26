<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/26/2022
  Time: 10:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>result</title>
</head>
<body>
    <%
            String description = request.getParameter("Description");
            double price = Double.parseDouble(request.getParameter("Price"));
            double discount_percent = Double.parseDouble(request.getParameter("DiscountPercent"));
            double discount = price*discount_percent * 0.01;
            double total = price - discount ;
    %>
<h2>Product Description : <%=description%></h2>
<h2>Product Price : <%=price%></h2>
<h2>Product Discount percent : <%=discount_percent%></h2>
<h2>Product Total : <%=total%></h2>
</body>
</html>
