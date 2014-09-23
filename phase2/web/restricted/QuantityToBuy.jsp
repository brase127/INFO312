<%-- 
    Document   : QuantityToBuy
    Created on : 18/09/2014, 7:50:06 PM
    Author     : Kendall Lauren Chin
--%>

<%@page import="dao.ProductJdbcDAO"%>
<%@page import="domain.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quantity To Buy</title>
    </head>
    <body><div id="logo"></div>
        <div>
        
        <%            
        String productName = "";
            String quantity = "";
            Product product = (Product) session.getAttribute("product");
            String description = "";
            Double price = null;

            if (product != null) {
                productName = product.getName();
                quantity = String.valueOf(product.getQuantity());
                description = product.getDescription();
                price = product.getPrice();
            }
        %>
        
        <h1><%= "You selected: " + productName%></h1>
        <div align="center">
        <%=description%>
        <br>
        <br
            >
        </div>
        <form action="/shopping/AddToOrderServlet" method="post">
            <fieldset>
                <legend>Quantity to buy</legend>
                <p>Stock Available: <%=quantity%></p>
                <p>Price: $<%=price%></p>
                <label>Quantity<input type="text" name="quantity"></label>
                <button type="submit" name="quantityToOrder" value="<%=request.getAttribute("quantity")%>">Add To Order</button>
            </fieldset>
        </form>

    </body>
</html>
