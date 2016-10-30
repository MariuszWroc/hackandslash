<%-- 
    Document   : characters
    Created on : Oct 31, 2015, 11:27:13 AM
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
        <title>Show characters</title>
    </head>
    <body>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	        <h2>List of characters</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>first name</td><td>last name</td><td>gender</td>
	                <td>age</td><td>race</td><td>profession</td><td>strength</td>
	                <td>dexterity</td><td>constitution</td><td>intelligence</td><td>baseHP</td><td>experience</td>
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
	                    <td>${character.baseHP}</td>
	                    <td>${character.experience}</td>
	                    <td><a href="<c:url value='/admin/characters/edit/${character.id}' />">Edit</a></td>
						<td><a href="<c:url value='/admin/characters/remove/${character.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>Add/Edit character</h2>  
	        <c:url var="addAction" value="/admin/characters/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_character">  
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
	                        <form:label path="firstname"><spring:message text="first name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="firstname" />
	                    </td> 
	                </tr>   
	                <tr>
	                    <td>
	                        <form:label path="lastname"><spring:message text="last name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="lastname" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="gender"><spring:message text="Gender"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="gender" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="age"><spring:message text="age"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="age" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="race"><spring:message text="race"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="race" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="profession"><spring:message text="profession"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="profession" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="strength"><spring:message text="strength"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="strength" />
	                    </td> 
	                </tr>
	                <tr>
	                    <td>
	                        <form:label path="dexterity"><spring:message text="dexterity"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="dexterity" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="constitution"><spring:message text="constitution"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="constitution" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="profession"><spring:message text="profession"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="profession" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="intelligence"><spring:message text="intelligence"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="intelligence" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="baseHP"><spring:message text="baseHP"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="baseHP" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="experience"><spring:message text="experience"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="experience" />
	                    </td> 
	                </tr> 
	                <tr>  
	                    <td colspan="2">
	                    	<c:if test="${!empty one_character.id}">
	                    		<input type="submit" name="action" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_character.id}">
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
