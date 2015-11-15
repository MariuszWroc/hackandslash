<%-- 
    Document   : quests
    Created on : Oct 31, 2015, 12:41:58 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show quests</title>
    </head>
    <body>
        <h2>List of quests</h2>  
        <table>
            <tr>
                <td>Id</td><td>description</td><td>target</td>
            </tr>
            <c:forEach items="${quests}" var="quest">
                <tr>
                    <td>${quest.id}</td>
                    <td>${quest.description}</td>
                    <td>${quest.target}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>One quest</h2>
        <table>
            <tr>
                <td>Id</td><td>description</td><td>target</td>
            </tr>
            <tr>
                <td>${one_quest.id}</td>
                <td>${one_quest.description}</td>
                <td>${one_quest.target}</td>
            </tr>
        </table>
    </body>
</html>
