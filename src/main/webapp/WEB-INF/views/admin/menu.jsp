<%-- 
    Document   : admin panel
    Created on : Oct 31, 2015, 12:46:01 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
        <h1>View database queries results</h1>
        <a href="${contextPath}/admin/characters">characters</a><br/>
        <a href="${contextPath}/admin/roles">roles</a><br/>
        <a href="${contextPath}/admin/users">users</a><br/>
        <a href="${contextPath}/admin/heroes">heroes</a><br/>
        <a href="${contextPath}/admin/equipments">equipments</a><br/>
        <a href="${contextPath}/admin/items">items</a><br/>
        <a href="${contextPath}/admin/journals">journals</a><br/>
        <a href="${contextPath}/admin/npcs">npcs</a><br/>
        <a href="${contextPath}/admin/places">places</a><br/>
        <a href="${contextPath}/admin/quests">quests</a>
        <h2>Testing registration and login procedure</h2>
        <a href="${contextPath}/admin/registerTest">register user</a><br/>
        <a href="${contextPath}/admin/heroTest">create Hero</a><br/>
        <a href="${contextPath}/admin/email">Send email</a><br/>
        <h2>---</h2>
        <a href="${contextPath}/admin/logout">logout</a><br/>
        <a href="${contextPath}/">start page</a><br/>
    </body>
</html>
