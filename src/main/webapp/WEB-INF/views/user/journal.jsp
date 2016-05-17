<%-- 
    Document   : journal
    Created on : Mar 24, 2016, 10:49:17 AM
    Author     : Mariusz
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="gameController" flex id="content">
		    <md-content layout="column" flex class="md-padding">
		    	<div class="tablecontainer">
                            <table class="table table-hover">
                                    <thead>
                                            <tr>
                                                    <th>Quest description</th>
                                                    <th width="20%"></th>
                                                    <th width="30%"></th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                            <tr ng-repeat="quest in journal.questList">
                                                    <td>{{quest.description}}</td>
                                                    <td>
                                                        <button type="button" ng-click="questSelect(quest)"
                                                                class="btn btn-success custom-width">Details</button>
                                                    </td>
                                                    <td>
                                                        <button type="button" style="width: 250px !important" ng-click="abandonQuest($index)"
                                                                class="btn btn-success custom-width">Abandon quest</button>
                                                    </td>
                                            </tr>
                                    </tbody>
                            </table>
                        </div>
                        <div class="tablecontainer">
                            <table class="table table-hover">
                                    <thead>
                                            <tr>
                                                    <th>Assignment description</th>
                                                    <th>Target</th>
                                                    <th width="20%"></th>
                                            </tr>
                                    </thead>
                                    <tbody>
                                            <tr ng-repeat="assignment in sellectedQuest.assignmentList track by $index">
                                                    <td>{{assignment.description}}</td>
                                                    <td>{{assignment.target}}</td>
                                            </tr>
                                    </tbody>
                            </table>
                        </div>
                        <button type="button" ng-click="restoreView()"
                                class="btn btn-success custom-width">restore</button>
		    </md-content>  
		</div>
	</body>
</html>
