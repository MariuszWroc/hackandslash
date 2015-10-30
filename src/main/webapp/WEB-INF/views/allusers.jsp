<%-- 
    Document   : allusers
    Created on : Oct 29, 2015, 5:27:27 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show users</title>
    </head>
    <body>
        <h2>List of users</h2>  
    <table>
        <tr>
            <td>Name</td><td>Last name</td><td>Login</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.login}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <a href="<c:url value='/new' />">Add New Employee</a>
    </body>
</html>
