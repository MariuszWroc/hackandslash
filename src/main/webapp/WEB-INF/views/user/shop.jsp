<%-- 
    Document   : shop
    Created on : Mar 24, 2016, 10:49:28 AM
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
                        <label>{{cash}} gold available</label>
                        <div layout="row">
                            <div class="tablecontainer">
                                <table class="table table-hover">
                                        <thead>
                                                <tr>
                                                    <th>Item name</th>
                                                    <th>Item price</th>
                                                    <th width="20%"></th>
                                                </tr>
                                        </thead>
                                        <tbody>
                                                <tr ng-repeat="item in shop">
                                                        <td>{{item.label}}</td>
                                                        <td>{{item.price}}</td>
                                                        <td>
                                                            <button type="button" ng-click="buy(item.id)"
                                                                    class="btn btn-success custom-width">Buy</button>
                                                        </td>
                                                </tr>
                                        </tbody>
                                </table>
                            </div>
                            <div class="tablecontainer">
                                <table class="table table-hover">
                                        <thead>
                                                <tr>
                                                    <th>Item name</th>
                                                    <th>Sell price</th>
                                                    <th width="20%"></th>
                                                </tr>
                                        </thead>
                                        <tbody>
                                                <tr ng-repeat="item in bought track by $index">
                                                        <td>{{item.label}}</td>
                                                        <td>{{item.price}}</td>
                                                        <td>
                                                            <button type="button" ng-click="sellBack($index)"
                                                                    class="btn btn-success custom-width">Sell</button>
                                                        </td>
                                                </tr>
                                        </tbody>
                                </table>
                            </div>
                        </div>
                        <button type="button" ng-click="restoreShop()"
                                class="btn btn-success custom-width">restore</button>
		    </md-content>
		</div>
	</body>
</html>
