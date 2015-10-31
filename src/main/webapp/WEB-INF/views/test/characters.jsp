<%-- 
    Document   : characters
    Created on : Oct 31, 2015, 11:27:13 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show characters</title>
    </head>
    <body>
        <h2>List of characters</h2>  
        <table>
            <tr>
                <td>Id</td><td>first name</td><td>last name</td><td>gender</td>
                <td>age</td><td>race</td><td>profession</td><td>strength</td>
                <td>dexterity</td><td>constitution</td><td>intelligence</td><td>charisma</td>
            </tr>
            <c:forEach items="${characters}" var="character">
                <tr>
                    <td>${character.id}</td>
                    <td>${character.firstname}</td>
                    <td>${character.lastname}</td>
                    <td>${character.gender}</td>
                    <td>${character.age}</td>
                    <td>${character.race}</td>
                    <td>${character.profession}</td>
                    <td>${character.strength}</td>
                    <td>${character.dexterity}</td>
                    <td>${character.constitution}</td>
                    <td>${character.intelligence}</td>
                    <td>${character.charisma}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
