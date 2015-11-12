<%-- 
    Document   : register
    Created on : Oct 31, 2015, 12:41:58 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert user (register)</title>
    </head>
    <title>Registration</title>
</head>
<body>
    <div align="center">
        <form:form commandName="registerForm">
            <table>
                <tr>
                    <td colspan="2" align="center"><h2>Registration</h2></td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td><form:input path="login" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
