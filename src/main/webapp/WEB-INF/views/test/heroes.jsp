<%-- 
    Document   : heroes
    Created on : Oct 31, 2015, 12:43:47 PM
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
        <title>Show heroes</title>
    </head>
    <body>
    	<div>
	        <h2>List of heroes</h2>  
	        <table>
	            <tr>
	                <td>id</td><td>activated</td><td>money</td>
	            </tr>
	            <c:forEach items="${heroes}" var="hero">
	                <tr>
	                    <td>${hero.id}</td>
	                    <td>${hero.activated}</td>
	                    <td>${hero.money}</td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>One hero</h2>
	        <table>
	            <tr>
	                <td>id</td><td>activated</td><td>money</td>   
	            </tr>
	            <tr>
	                <td>${one_hero.id}</td>
	                <td>${one_hero.activated}</td>
	                <td>${one_hero.money}</td>
	            </tr>
	        </table>
        </div>
        <div>
        	<h2>Add/Edit hero</h2>  
	        <c:url var="addAction" value="/heroes/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_hero">  
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
	                        <form:label path="activated"><spring:message text="Activated"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="activated" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="money"><spring:message text="Money"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="money" />
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
