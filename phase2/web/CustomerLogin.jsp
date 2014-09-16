<%-- 
    Document   : CustomerLogin
    Created on : 16/09/2014, 11:24:24 AM
    Author     : chike189
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/shopping/style.css">
        <title>Customer Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
       <%@include file="/WEB-INF/jspf/NavigationMenu.jspf" %>
    </head>
    
<%    // get the status code to see why the log in page was requested
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    // default message to display to the user
    String message = "Please log in to continue.";
    // if the status code was 401 (UNAUTHORIZED) then extract the message
    // from the request
    if (statusCode != null && statusCode == HttpServletResponse.SC_UNAUTHORIZED) {
        message = request.getAttribute("javax.servlet.error.message").toString();
    }
%>


    
    <body>
        <div>
            <form action="/shopping/LoginServlet" method="post">
                <fieldset>
                    <legend>Login Details</legend>
                    <label>User Name:<input type="text" name="username"></label>
                    <label>Password:<input type="password" name="password"></label>
                    <button type="submit">Login</button>
                    <%=message%>    
                </fieldset>
            </form>
        </div>
    </body>
</html>
