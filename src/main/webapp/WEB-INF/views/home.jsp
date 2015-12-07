<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en" ng-app="StarterApp">
<head>
    <title>AngularJS Routes example</title>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-route.min.js"></script>
                <!--     Angular Material Dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
            <!-- Javascript beside shivs goes here -->
    <script src="${contextPath}/resources/js/app.js"></script>
    <script src="${contextPath}/resources/js/heroController.js"></script>
    <script src="${contextPath}/resources/js/loginController.js"></script>
    <script src="${contextPath}/resources/js/registerController.js"></script>
    <script src="${contextPath}/resources/js/sideNav.js"></script>
    <meta name="viewport" content="initial-scale=1" />
</head>

<body layout="column" ng-app="StarterApp" ng-controller="AppCtrl">
	<md-toolbar layout="row">
      <div class="md-toolbar-tools">
        <md-button ng-click="toggleSidenav('left')" class="md-icon-button">
          <md-icon aria-label="Menu" md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg"></md-icon>
        </md-button>
        <h1>Hack and slash home</h1>
      </div>
    </md-toolbar>
    <div layout="row" flex>
    	<md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2" md-component-id="left">
    		<md-button md-raised md-primary layout-fill href="#/register">Register</md-button>
    		<md-button md-raised md-primary layout-fill href="#/login">Log in</md-button>
    		<md-button md-raised md-primary layout-fill href="#/authors">Authors</md-button>
    		<md-button md-raised md-primary layout-fill href="#/contact">Contact</md-button>
    		<md-button md-raised md-primary layout-fill href="#/about">About Game</md-button>
    		<md-button md-raised md-primary layout-fill href="#/user">User</md-button>
    		<md-button md-raised md-primary layout-fill href="#/hero">Hero</md-button>
    	</md-sidenav>
        <md-content layout="column" flex class="md-padding">
            <div ng-view></div>
        </md-content>
    </div>

