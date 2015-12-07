<%-- 
    Document   : allusers
    Created on : Oct 29, 2015, 5:27:27 PM
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
        <title>Show users</title>
    </head>
    <body>
    	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    	<div>
	        <h2>List of users</h2>  
	        <table>
	            <tr>
	                <td>Id</td><td>First name</td><td>Last name</td>
	                <td>Login</td><td>Age</td><td>Password</td>
	                <td>Gender</td><td>Activated</td>
	            </tr>
	            <c:forEach items="${users}" var="user">
	                <tr>
	                	<td>${user.id}</td>
	                    <td>${user.firstname}</td>
	                    <td>${user.lastname}</td>
	                    <td>${user.login}</td>
	                    <td>${user.age}</td>
	                    <td>${user.password}</td>
	                    <td>${user.gender}</td>
	                    <td>${user.activated}</td>
	                    <td><a href="<c:url value='/admin/users/edit/${user.id}' />">Edit</a></td>
						<td><a href="<c:url value='/admin/users/remove/${user.id}' />">Delete</a></td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>Add/Edit user</h2>  
	        <c:url var="addAction" value="/admin/users/add" ></c:url>
	        <form:form id="registerForm" method="POST" action="${addAction}" commandName="one_user">  
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
	                        <form:label path="firstname"><spring:message text="First name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="firstname" />
	                    </td> 
	                </tr> 
	                <tr>
	                    <td>
	                        <form:label path="lastname"><spring:message text="Last name"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="lastname" />
	                    </td> 
	                </tr>
	                <tr>
	                    <td>
	                        <form:label path="login"><spring:message text="Login"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="login" />
	                    </td> 
	                </tr>
	                 <tr>
	                    <td>
	                        <form:label path="age"><spring:message text="Age"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="age" />
	                    </td> 
	                </tr>  
	                <tr>
	                    <td>
	                        <form:label path="password"><spring:message text="Password"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="password" />
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
	                        <form:label path="activated"><spring:message text="Activated"/></form:label>
	                    </td>
	                    <td>
	                        <form:input path="activated" />
	                    </td> 
	                </tr>
	                <tr>  
	                    <td colspan="2">
	                    	<c:if test="${!empty one_user.id}">
	                    		<input type="submit" name="action" value="Edit"/>
	                    	</c:if>
	                    	<c:if test="${empty one_user.id}">
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
