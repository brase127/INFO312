<%-- 
    Document   : ViewProduct
    Created on : 16/09/2014, 1:14:57 PM
    Author     : chike189
--%>

<%@page import="java.util.Collection"%>
<%@page import="domain.Product"%>
<%@page import="dao.ProductJdbcDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Products</title>
    </head>
    <body>
        <div id="logo"></div>
        <h1>View Products</h1>
        <%            Collection<Product> products = new ProductJdbcDAO().getAll();
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Product Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <% for (Product product : products) {%>
                <tr>
                    <td><%=product.getId()%></td>
                    <td><%=product.getName()%></td>
                    <td><%=product.getDescription()%></td>
                    <td><%=product.getCategory()%></td>
                    <td><%=product.getPrice()%></td>
                    <td><%=product.getQuantity()%></td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
