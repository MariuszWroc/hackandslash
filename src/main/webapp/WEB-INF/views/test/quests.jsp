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
                <td>Id</td><td>description</td><td>target</td><td>start date</td>
            </tr>
            <c:forEach items="${quests}" var="quest">
                <tr>
                    <td>${quest.id}</td>
                    <td>${quest.description}</td>
                    <td>${quest.target}</td>
                    <td>${quest.startDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
