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
                <td>Id</td><td>Password</td><td>Age</td>
                <td>Gender</td><td>Activated</td>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.login}</td>
                    <td>${user.age}</td>
                    <td>${user.id}</td>
                    <td>${user.password}</td>
                    <td>${user.gender}</td>
                    <td>${user.activated}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>One user</h2>
        <table>
            <tr>
                <td>Name</td><td>Last name</td><td>Login</td>
                <td>Id</td><td>Password</td><td>Age</td>
                <td>Gender</td><td>Activated</td>
            </tr>
            <tr>
                <td>${one_user.id}</td>
                <td>${one_user.firstname}</td>
                <td>${one_user.lastname}</td>
                <td>${one_user.login}</td>
                <td>${one_user.age}</td>
                <td>${one_user.password}</td>
                <td>${one_user.gender}</td>
                <td>${one_user.activated}</td>
            </tr>
        </table>
    </body>
</html>
