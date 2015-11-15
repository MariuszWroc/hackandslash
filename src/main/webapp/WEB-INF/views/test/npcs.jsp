<%-- 
    Document   : npcs
    Created on : Oct 31, 2015, 12:44:40 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show npcs</title>
    </head>
    <body>
        <h2>List of npcs</h2>  
        <table>
            <tr>
                <td>Id</td><td>behaviour</td>
            </tr>
            <c:forEach items="${npcs}" var="npc">
                <tr>
                    <td>${npc.id}</td>
                    <td>${npc.behaviour}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>One npc</h2>
        <table>
            <tr>
                <td>Id</td><td>behaviour</td>
            </tr>
            <tr>
                <td>${one_npc.id}</td>
                <td>${one_npc.behaviour}</td>
            </tr>
        </table>
    </body>
</html>
