<%-- 
    Document   : journals
    Created on : Oct 31, 2015, 12:44:03 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show journals</title>
    </head>
    <body>
        <h2>List of journals</h2>  
        <table>
            <tr>
                <td>id</td><td>passed</td><td>start date</td>
            </tr>
            <c:forEach items="${journals}" var="journal">
                <tr>
                    <td>${journal.id}</td>
                    <td>${journal.passed}</td>
                    <td>${journal.startDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
