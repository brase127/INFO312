<%-- 
    Document   : ViewProduct
    Created on : 16/09/2014, 1:14:57 PM
    Author     : chike189
--%>

<%@page import="java.text.NumberFormat"%>
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
        <form action="/shopping/BuyServlet" method="post">

            <h1>View Products</h1>
            <%                Collection<Product> products = new ProductJdbcDAO().getAll();
                ProductJdbcDAO dao = new ProductJdbcDAO();
            %>
            <div id="categories" align= "center" id="categories">
                <a> Categories: </a>
                    <a href="/shopping/restricted/ViewProducts.jsp?category=all">All</a> 
                <% Collection<String> categories = dao.getCategories();

                    for (String cat : categories) {%>
                 <a href="/shopping/restricted/ViewProducts.jsp?category=<%=cat%>" id="category" value="<%=cat%>"><%=cat%></a>
                <%
                        request.setAttribute("category", cat);
                    }
                %>
                <br>
                <br>
            </div>

<div align="center">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Category</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Product product : products) {
                            
                            NumberFormat formatter = NumberFormat.getCurrencyInstance();
                            String fPrice = formatter.format(product.getPrice());
                            
                            String category = request.getParameter("category");
                            if (category == null || product.getCategory().equals(category) || category.equals("all")) {
                                Integer quantity = product.getQuantity();
                    %>
                    <tr>
                        <td><img src="/shopping/<%=product.getPhoto()%>" height="80" width="80" alt="No photo available"></td>
                        <td><button type="submit" name="productId" value="<%=product.getId()%>"><%=product.getName()%></button></td>
                        <td><%=product.getCategory()%></td>
                        <td><%=fPrice%></td>
                        <%if (quantity <= 0) {%>
                        <td>Sold out!</td>
                        <td> </td>
                        <%} else {%>
                        <td><%=product.getQuantity()%></td>
                        
                        <td><button type="submit" name="productId" value="<%=product.getId()%>">Buy</button></td>
                    <%}%>
                    
                    </tr>

                    <% }
                        }%>

                </tbody>
            </table>
</div>>
        </form>
    </body>
</html>
