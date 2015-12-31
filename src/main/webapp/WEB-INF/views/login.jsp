<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <body ng-cloak class="ng-cloak">
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <md-dialog aria-label="Logout dialog">
            <md-dialog-content>
                <div ng-controller="menuController" class="container" id="login-box">
                    <c:url var="loginAction" value="/j_spring_security_check" />
                    <form:form action="${loginAction}" method="POST" accept-charset="UTF-8">
                        <table>
                            <tr>
                                <td>
                                        <spring:message text="Login:"/>
                                </td>
                                <td>
                                        <input type="text" name="username" value="" required>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                        <spring:message text="Password:"/>
                                </td>
                                <td>
                                        <input type="password" name="password" value="" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <md-button type="button" ng-click="cancel()"> Cancel </md-button>
                                </td>
                                <td colspan='2'>
                                    <md-button name="submit" class="md-primary" type="submit"> submit </md-button>
                                </td>
                            </tr>
                        </table>

                        <input type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}" />
                    </form:form>
                </div>
            </md-dialog-content>
        </md-dialog>
    </body>
</html>