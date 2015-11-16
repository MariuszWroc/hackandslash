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
    	<div>
	        <h2>List of users</h2>  
	        <table>
	            <tr>
	                <td>Name</td><td>Last name</td><td>Login</td>
	                <td>Id</td><td>Password</td><td>Age</td>
	                <td>Gender</td><td>Activated</td>
	            </tr>
	            <c:forEach items="${users}" var="user">
	                <tr>
	                    <td>${user.firstname}</td>
	                    <td>${user.lastname}</td>
	                    <td>${user.login}</td>
	                    <td>${user.age}</td>
	                    <td>${user.id}</td>
	                    <td>${user.password}</td>
	                    <td>${user.gender}</td>
	                    <td>${user.activated}</td>
	                </tr>
	            </c:forEach>
	        </table>
        </div>
        <div>
	        <h2>One user</h2>
	        <table>
	            <tr>
	                <td>Name</td><td>Last name</td><td>Login</td>
	                <td>Id</td><td>Password</td><td>Age</td>
	                <td>Gender</td><td>Activated</td>
	            </tr>
	            <tr>
	                <td>${one_user.id}</td>
	                <td>${one_user.firstname}</td>
	                <td>${one_user.lastname}</td>
	                <td>${one_user.login}</td>
	                <td>${one_user.age}</td>
	                <td>${one_user.password}</td>
	                <td>${one_user.gender}</td>
	                <td>${one_user.activated}</td>
	            </tr>
	        </table>
        </div>
        <div>
	        <h2>Add/Edit user</h2>  
	        <c:url var="addAction" value="/users/add" ></c:url>
	        <form:form method="POST" action="${addAction}" commandName="one_user">  
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
	                    <td colspan="2"><input type="submit" value="Submit"/></td>  
	                </tr>  
	            </table>   
	        </form:form>   
        </div>
    </body>
</html>
