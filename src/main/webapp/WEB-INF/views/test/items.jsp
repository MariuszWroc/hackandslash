<%-- 
    Document   : items
    Created on : Oct 31, 2015, 12:43:54 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show items</title>
    </head>
    <body>
        <h2>List of items</h2>  
        <table>
            <tr>
                <td>Id</td><td>name</td><td>type</td><td>wage</td>
                <td>attack</td><td>defend</td><td>magic</td><td>addHealth</td>
                <td>addStrength</td><td>addDexterity</td><td>addConstitution</td>
                <td>addIntelligence</td><td>addCharisma</td><td>amount</td>
            </tr>
            <c:forEach items="${items}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.category}</td>
                    <td>${item.wage}</td>
                    <td>${item.attack}</td>
                    <td>${item.defend}</td>
                    <td>${item.magic}</td>
                    <td>${item.addHealth}</td>
                    <td>${item.addStrength}</td>
                    <td>${item.addDexterity}</td>
                    <td>${item.addConstitution}</td>
                    <td>${item.addIntelligence}</td>
                    <td>${item.addCharisma}</td>
                    <td>${item.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
