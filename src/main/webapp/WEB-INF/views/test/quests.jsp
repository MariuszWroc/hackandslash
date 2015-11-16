<%-- 
    Document   : quests
    Created on : Oct 31, 2015, 12:41:58 PM
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
        <div>
        	<h2>Add/Edit quest</h2>  
	        <c:url var="addAction" value="/quests/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_quest">  
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
	                        <form:label path="description"><spring:message text="Description"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="description" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="target"><spring:message text="Target"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="target" />
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
