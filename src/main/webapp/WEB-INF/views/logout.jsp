<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
    <c:url var="logoutUrl" value="${contextPath}/j_spring_security_logout" />
    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <md-dialog aria-label="Logout dialog">
        <md-dialog-content>
            <form action="${logoutUrl}" method="POST" id="logoutForm" accept-charset="UTF-8">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div layout="column">
                    <h3>Are you sure you wish to proceed and log out?</h3>
                    <div id="logoutButton" class="md-actions" layout="row">
                        <md-button type="button" ng-click="cancel()" ng-hide="fromUserProfile"> Cancel </md-button>
                        <input type="submit" class="btn btn-primary btn-sm" value="{{!fromUserProfile ? 'OK' : 'Log out'}}"/>  <!-- ng-click="close(kind)" no need for it -->
                    </div>
                </div>
            </form>
       </md-dialog-content>
    </md-dialog>
</body>
</html>