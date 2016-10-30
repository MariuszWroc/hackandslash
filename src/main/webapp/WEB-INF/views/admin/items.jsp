<%-- 
    Document   : items
    Created on : Oct 31, 2015, 12:43:54 PM
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
        <title>Show items</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	        <h2>List of items</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>name</td><td>type</td><td>wage</td>
	                <td>attack</td><td>defend</td><td>magic</td><td>addHealth</td>
	                <td>addStrength</td><td>addDexterity</td><td>addConstitution</td>
	                <td>addIntelligence</td><td>amount</td>
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
	                    <td>${item.amount}</td>
	                    <td><a href="<c:url value='/admin/items/edit/${item.id}' />">Edit</a></td>
						<td><a href="<c:url value='/admin/items/remove/${item.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
	    </div>
        <div>
        <h2>Add/Edit item</h2>  
	        <c:url var="addAction" value="/admin/items/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_item">  
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
	                        <form:label path="name"><spring:message text="Name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="name" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="category"><spring:message text="Category"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="category" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="wage"><spring:message text="Wage"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="wage" />
	                    </td> 
	                </tr>
	                <tr>
	                    <td>
	                        <form:label path="attack"><spring:message text="Attack"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="attack" />
	                    </td> 
	                </tr> 
	                	                <tr>
	                    <td>
	                        <form:label path="defend"><spring:message text="Defend"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="defend" />
	                    </td> 
	                </tr> 
	                	                <tr>
	                    <td>
	                        <form:label path="magic"><spring:message text="Magic"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="magic" />
	                    </td> 
	                </tr> 
	                	                <tr>
	                    <td>
	                        <form:label path="addHealth"><spring:message text="Add Health"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="addHealth" />
	                    </td> 
	                </tr> 
	                	                <tr>
	                    <td>
	                        <form:label path="addStrength"><spring:message text="Add Strength"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="addStrength" />
	                    </td> 
	                </tr>
	                	                	                <tr>
	                    <td>
	                        <form:label path="addDexterity"><spring:message text="Add Dexterity"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="addDexterity" />
	                    </td> 
	                </tr>
	                	                	                <tr>
	                    <td>
	                        <form:label path="addConstitution"><spring:message text="Add Constitution"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="addConstitution" />
	                    </td> 
	                </tr>  
	                	                	                	                <tr>
	                    <td>
	                        <form:label path="addIntelligence"><spring:message text="Add Intelligence"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="addIntelligence" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="amount"><spring:message text="Amount"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="amount" />
	                    </td> 
	                </tr>
	                <tr>  
		            	<td colspan="2">
	                    	<c:if test="${!empty one_item.id}">
	                    		<input type="submit" name="action" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_item.id}">
	                    		<input type="submit" name="action" value="Add"/>
	                    	</c:if>
	                    	<input type="submit" name="action" value="Clear" />
	                    </td> 
	                </tr>  
	            </table>   
	        </form:form> 
        </div>
        	<div>
				<p>
					<a href="${contextPath}/admin/panel">powrót</a>
				</p>
			</div>
    </body>
</html>
