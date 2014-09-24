<%-- 
    Document   : OtherError
    Created on : 17/09/2014, 4:31:14 PM
    Author     : Kendall Lauren Chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="/shopping/style.css">
    <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>
    <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    <body>
        <h1>Error</h1>
        <form>
            <fieldset>
        <%=request.getAttribute("javax.servlet.error.message")%>
        <br>
        <br>
        <br>
        <a href="javascript:history.back()">Back</a>
        </fieldset
        </form>
    </body>
</html>
