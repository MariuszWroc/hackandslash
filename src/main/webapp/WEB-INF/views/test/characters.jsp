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
                <td>dexterity</td><td>constitution</td><td>intelligence</td>
                <td>charisma</td><td>baseHP</td><td>experience</td>
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
                    <td>${character.baseHP}</td>
                    <td>${character.experience}</td>
                </tr>
            </c:forEach>
        </table>
        <h2>One character</h2>
        <table>
                <tr>
                    <td>Id</td><td>first name</td><td>last name</td><td>gender</td>
                    <td>age</td><td>race</td><td>profession</td><td>strength</td>
                    <td>dexterity</td><td>constitution</td><td>intelligence</td>
                    <td>charisma</td><td>baseHP</td><td>experience</td>
                </tr>
                <tr>
                    <td>${one_character.id}</td>
                    <td>${one_character.firstname}</td>
                    <td>${one_character.lastname}</td>
                    <td>${one_character.gender}</td>
                    <td>${one_character.age}</td>
                    <td>${one_character.race}</td>
                    <td>${one_character.profession}</td>
                    <td>${one_character.strength}</td>
                    <td>${one_character.dexterity}</td>
                    <td>${one_character.constitution}</td>
                    <td>${one_character.intelligence}</td>
                    <td>${one_character.charisma}</td>
                    <td>${one_character.baseHP}</td>
                    <td>${one_character.experience}</td>
                </tr>
        </table>
    </body>
</html>
