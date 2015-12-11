<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html lang="en" ng-app="StarterApp">
<head>
<title>AngularJS Routes example</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/home.css">
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
<!--     Angular Material Dependencies -->
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<!-- Javascript beside shivs goes here -->
<script src="${contextPath}/resources/js/app.js"></script>
<script src="${contextPath}/resources/js/heroController.js"></script>
<script src="${contextPath}/resources/js/loginController.js"></script>
<script src="${contextPath}/resources/js/registerController.js"></script>
<script src="${contextPath}/resources/js/sideNav.js"></script>
<meta name="viewport" content="initial-scale=1" />
</head>

<body layout="column" ng-app="StarterApp" ng-controller="AppCtrl">
	<div id="wrapper">
		<div id="headerwrap">
			<div id="header">
				<md-toolbar layout="row">
				<div class="md-toolbar-tools">
					<md-button ng-click="toggleSidenav('left')" class="md-icon-button">
					<md-tooltip>Side Panel</md-tooltip> <md-icon aria-label="Menu"
						md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg"></md-icon>
					</md-button>
					<h1>
						<span>Hack and slash home</span>
					</h1>
					<span flex></span>
					<md-button class="md-icon-button" aria-label="Log in" href="#/login">
						<md-tooltip>Log in</md-tooltip> <img src="login.png"
						style="width: 24px; height: 24px;" /> 
					</md-button>
					<md-button class="md-icon-button" aria-label="Register" href="#/register">
						<md-tooltip>Register</md-tooltip> <img src="register.png"
						style="width: 24px; height: 24px;" /> 
					</md-button>
				</div>
				</md-toolbar>
			</div>
		</div>
		<div id="leftcolumnwrap">
			<div id="leftcolumn">
				<div layout="row" flex>
					<md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2" md-component-id="left">
						<md-toolbar layout="row">
							<div class="md-toolbar-tools">
								<h2>
									<span>Side Panel</span>
								</h2>
								<md-button ng-click="toggleSidenav('left')" class="md-icon-button">
									<md-tooltip>Click for close</md-tooltip>
									<md-icon aria-label="Menu" md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg"/>
								</md-button>
							</div>
						</md-toolbar> 
						<md-content layout-padding="">
							<md-button md-raised md-primary layout-fill href="#/user/profil">Profil</md-button> 
							<md-button md-raised md-primary layout-fill href="#/hero">Heroes</md-button> 
						</md-content> 
					</md-sidenav>
				</div>
			</div>
		</div>
		<div id="contentwrap">
			<div id="content">
				<md-content layout="column" flex class="md-padding">
					<div ng-view align="center"></div>
				</md-content>
			</div>
		</div>
		<div id="footerwrap">
			<div id="footer" layout="row" layout-align="center center">
				<p>
					<a id="link-3" ng-href="#/makers">Authors</a> 
					<a id="link-3" ng-href="#/contact">Contact</a> 
					<a id="link-3" ng-href="#/about">About</a> 
				</p>
			</div>
		</div>
	</div>