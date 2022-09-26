<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 9/26/2022
  Time: 10:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      h1 {
        text-align: center;
      }
      #content {
        width: 450px;
        margin: 0 auto;
        padding: 0 20px 20px;
        background: white;
      }
      label {
        width: 10em;
        padding-right: 1em;
        float: left;
      }
    </style>
  </head>
  <body>
  <div >
    <h1>Product Discount Calculator</h1>
    <form action="result.jsp" method="post">
      <div id="content">
        <div class="data">
          <label>Product Description</label>
          <input type="text" name="Description">
          <br>
          <label>Price</label>
          <input type="text" name="Price">
          <br>
          <label>Discount Percent</label>
          <input type="text" name="DiscountPercent">
        </div>
        <div id="submit">
          <input type="submit" value="Discount Product">
        </div>
      </div>
    </form>
  </div>
  </body>
</html>
