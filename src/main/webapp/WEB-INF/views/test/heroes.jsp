<%-- 
    Document   : heroes
    Created on : Oct 31, 2015, 12:43:47 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show heroes</title>
    </head>
    <body>
        <h2>List of heroes</h2>  
        <table>
            <tr>
                <td>Id</td><td>activated</td>
            </tr>
            <c:forEach items="${heroes}" var="hero">
                <tr>
                    <td>${hero.id}</td>
                    <td>${hero.activated}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
