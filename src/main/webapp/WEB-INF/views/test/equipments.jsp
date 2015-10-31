<%-- 
    Document   : equipments
    Created on : Oct 31, 2015, 11:26:48 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show equipments</title>
    </head>
    <body>
        <h2>List of equipments</h2>  
        <table>
            <tr>
                <td>Id</td><td>Role name</td>
            </tr>
            <c:forEach items="${equipments}" var="equipment">
                <tr>
                    <td>${equipment.id}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
