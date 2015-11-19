<%-- 
    Document   : testlist
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
        <a href="${contextPath}/characters">characters</a><br/>
        <a href="${contextPath}/roles">roles</a><br/>
        <a href="${contextPath}/users">users</a><br/>
        <a href="${contextPath}/heroes">heroes</a><br/>
        <a href="${contextPath}/equipments">equipments</a><br/>
        <a href="${contextPath}/items">items</a><br/>
        <a href="${contextPath}/journals">journals</a><br/>
        <a href="${contextPath}/npcs">npcs</a><br/>
        <a href="${contextPath}/places">places</a><br/>
        <a href="${contextPath}/quests">quests</a>
        <a href="${contextPath}/create_hero">quests</a>
        <p>Problemy z encjami<br/>>
        npc -- obiekt transferowy<br/>
		journal -- rozwiązanie: standardowy zestaw questów dla rasy<br/>
		equipment -- rozwiązanie: standardowy zestaw przedmiotów dla postaci o danej profesji<br/>
		heroes -- zadziała jeśli journal, equipment i character istnieją, obiekt transferowy</p>
    </body>
</html>
