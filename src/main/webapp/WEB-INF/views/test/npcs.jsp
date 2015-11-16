<%-- 
    Document   : npcs
    Created on : Oct 31, 2015, 12:44:40 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show npcs</title>
    </head>
    <body>
    	<div>
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
        </div>
        <div>
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
        </div>
        <div>
        	<h2>Add/Edit npc</h2>  
	        <c:url var="addAction" value="/npcs/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_npc">  
	            <table>  
	                <tr>  
	                    <td>
	                        <form:label path="id"><spring:message text="ID"/></form:label></td>  
	                    <td>
	                        <form:input path="id" readonly="true" size="8"  disabled="true" />
	                        <form:hidden path="id" />
	                    </td>  
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="behaviour"><spring:message text="Behaviour"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="behaviour" />
	                    </td> 
	                </tr>  
	                <tr>  
	                    <td colspan="2"><input type="submit" value="Submit"/></td>  
	                </tr>  
	            </table>   
	        </form:form> 
        </div>
    </body>
</html>
