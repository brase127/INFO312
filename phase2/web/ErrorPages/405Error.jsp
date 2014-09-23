<%-- 
    Document   : 405Error
    Created on : 17/09/2014, 5:37:20 PM
    Author     : Kendall Lauren Chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/shopping/style.css">
    <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>        <body>
        <h1>Invalid Method Post</h1>
        <p><%=request.getAttribute("javax.servlet.error.message")%></p>
        <br>
        <br>
        <br>
        <a href="javascript:history.back()">Back</a>
    </body>
</html>
