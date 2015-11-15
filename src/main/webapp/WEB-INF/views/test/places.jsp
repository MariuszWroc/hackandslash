<%-- 
    Document   : places
    Created on : Oct 31, 2015, 12:43:40 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show places</title>
    </head>
    <body>
        <h2>List of places</h2>  
        <table>
            <tr>
                <td>Id</td><td>latitude</td><td>longitude</td>
            </tr>
            <c:forEach items="${places}" var="place">
                <tr>
                    <td>${place.id}</td>
                    <td>${place.latitude}</td>
                    <td>${place.longitude}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>One place</h2>
        <table>     
            <tr>
                <td>Id</td><td>latitude</td><td>longitude</td>
            </tr>
            <tr>
                <td>${one_place.id}</td>
                <td>${one_place.latitude}</td>
                <td>${one_place.longitude}</td>
            </tr>
        </table>
    </body>
</html>
