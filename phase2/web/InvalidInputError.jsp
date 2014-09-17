<%-- 
    Document   : InvalidInputError
    Created on : 17/09/2014, 4:01:02 PM
    Author     : Kendall Lauren Chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <body>
        <h1>Invalid Input</h1>
        <p><%=request.getAttribute("javax.servlet.error.message")%></p>
        <a href="javascript:history.back()">Back</a>
    </body>
</html>
