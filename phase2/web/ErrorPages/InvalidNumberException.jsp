<%-- 
    Document   : InvalidNumberException
    Created on : 17/09/2014, 4:41:46 PM
    Author     : Kendall Lauren Chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/shopping/style.css">
    <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>        
    <body>
        <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <h1>Invalid Number Exception</h1>
        <div id="form">
            <fieldset>
                <%=request.getAttribute("javax.servlet.error.message")%>
                <br>
                <br>
                <br>
                <a href="javascript:history.back()">Back</a>
            </fieldset>>
        </div> 
    </body>
</html>
