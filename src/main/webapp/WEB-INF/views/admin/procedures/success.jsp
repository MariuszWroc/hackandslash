<%-- 
    Document   : success
    Created on : Oct 29, 2015, 5:24:12 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Confirmation Page</title>
    </head>
    <body>
        message : ${success}
        <br/>
        <table>        
	        <tr>
	        	<td>Login :</td> <td>${registerForm.login}</td>
	        	<td>Password :</td> <td>${registerForm.password}</td>
	        </tr>
		</table>
    </body>
</html>
