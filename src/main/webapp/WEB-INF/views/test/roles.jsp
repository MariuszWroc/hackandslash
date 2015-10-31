<%-- 
    Document   : roles
    Created on : Oct 31, 2015, 12:45:09 PM
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
        <h2>List of roles</h2>  
        <table>
            <tr>
                <td>Id</td><td>Role name</td>
            </tr>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.rolename}</td>
                </tr>
            </c:forEach>
        </table>
</html>
