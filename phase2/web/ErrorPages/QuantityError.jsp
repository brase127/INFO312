<%-- 
    Document   : QuantityError
    Created on : 26/09/2014, 2:23:56 PM
    Author     : Kendall Lauren Chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" type="text/css" href="/shopping/style.css">
    <link href='http://fonts.googleapis.com/css?family=Shadows+Into+Light' rel='stylesheet' type='text/css'>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
        <title>Quantity Error</title>
    </head>
    <body>
        <h1>You have selected too many of this item, please try again.</h1>
        <div id="form">
            <fieldset>
                
                <a href="javascript:history.back()">Back</a>
            </fieldset>
        </div> 
    </body>
</html>
