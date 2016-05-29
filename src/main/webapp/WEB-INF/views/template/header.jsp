<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<c:url var="addAction" value="/j_spring_security_logout" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div id="header" >
			<md-toolbar layout="row">
			<div class="md-toolbar-tools" id="popupContainer">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<md-button ng-click="toggleSidenav('left')" class="md-icon-button">
						<md-tooltip>Side Panel</md-tooltip> 
						<md-icon aria-label="Menu"
							md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg">
						</md-icon>
					</md-button>
				</c:if>
				<md-button class="md-flat" ng-href="#/">Hack and Slash</md-button> 
				<span flex></span>
				<c:if test="${pageContext.request.userPrincipal.name == null}">
					<md-button class="md-icon-button" aria-label="Log in" ng-click="login($event)">
						<md-tooltip>Log in</md-tooltip> 
						<img src="${contextPath}/resources/img/icons/login.svg"
							style="width: 24px; height: 24px;" /> 
					</md-button>
					<md-button class="md-icon-button" aria-label="Register" ng-href="#/register"> 
						<md-tooltip>Register</md-tooltip> 
						<img src="${contextPath}/resources/img/icons/account.svg"
							style="width: 24px; height: 24px;" /> 
					</md-button>
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<label class="font-size-small">Witaj, ${pageContext.request.userPrincipal.name}</label>
					<md-button class="md-icon-button" aria-label="Log out" ng-click="logout($event)">
						<md-tooltip>Log out</md-tooltip> 
						<img src="${contextPath}/resources/img/icons/login.svg"
							style="width: 24px; height: 24px;" /> 
					</md-button>
				</c:if>
			</div>
			</md-toolbar>
		</div>
	</body>
</html>