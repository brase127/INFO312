<%-- 
    Document   : CreateCustomer
    Created on : 16/09/2014, 5:05:40 PM
    Author     : chike189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create an Account</h1>
        <div>
            <form action="/shopping/LoginServlet" method="post">
                <fieldset>
                    <legend>Account Details</legend>
                    <label>User Name:<input type="text" name="username"></label>
                    <label>Name:<input type="text" name="name"></label>
                    <label>Email:<input type="text" name="email"></label>
                    <label>Address<input type="text" name="address"></label>
                    <label>Credit Card:<input type="text" name="creditCardDetails"></label>
                    <label>Password:<input type="password" name="password"></label>
                    <button type="submit">Create Account</button>                    
                </fieldset>
            </form>
        </div>
    </body>
</html>

