<%-- 
    Document   : equipments
    Created on : Oct 31, 2015, 11:26:48 AM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show equipments</title>
    </head>
    <body>
    	<div>
	        <h2>List of equipments</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>In place</td>
	            </tr>
	            <c:forEach items="${equipments}" var="equipment">
	                <tr>
	                    <td>${equipment.id}</td>
	                    <td>${equipment.inPlace}</td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>One equipment</h2>
	        <table>
	            <tr>
	                <td>Id</td><td>In place</td>
	            </tr>
	            <tr>
	                <td>${one_equipment.id}</td>
	                <td>${one_equipment.inPlace}</td>
	            </tr>
	        </table>
        </div>
        <div>
            <h2>Add/Edit equipment</h2>  
	        <c:url var="addAction" value="/equipments/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_equipment">  
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
	                        <form:label path="inPlace"><spring:message text="Is in place"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="inPlace" />
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
