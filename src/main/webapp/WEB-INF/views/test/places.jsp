<%-- 
    Document   : places
    Created on : Oct 31, 2015, 12:43:40 PM
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
        <title>Show places</title>
    </head>
    <body>
    	<div>
	        <h2>List of places</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>latitude</td><td>longitude</td>
	            </tr>
	            <c:forEach items="${places}" var="place">
	                <tr>
	                    <td>${place.id}</td>
	                    <td>${place.latitude}</td>
	                    <td>${place.longitude}</td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>One place</h2>
	        <table>     
	            <tr>
	                <td>Id</td><td>latitude</td><td>longitude</td>
	            </tr>
	            <tr>
	                <td>${one_place.id}</td>
	                <td>${one_place.latitude}</td>
	                <td>${one_place.longitude}</td>
	            </tr>
	        </table>
        </div>
         <div>
        	<h2>Add/Edit place</h2>  
	        <c:url var="addAction" value="/places/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_place">  
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
	                        <form:label path="latitude"><spring:message text="Latitude"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="latitude" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="longitude"><spring:message text="Longitude"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="longitude" />
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
