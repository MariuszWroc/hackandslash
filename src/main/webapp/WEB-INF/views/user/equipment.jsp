<%-- 
    Document   : equipment
    Created on : Mar 24, 2016, 10:50:50 AM
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
		    	<div id="game" class="panel panel-default">
		    		<div class="panel-heading">
		    			<span class="lead">Equipment</span>
		    		</div>
					<div class="formcontainer">
                                            <form ng-submit="saveEquipment()" method="post" name="equipmentForm"class="form-horizontal">
                                                <div class="row">
                                                        <div class="form-group form-group-lg">
                                                                <label class="col-md-2 control-label" for="file">Gloves</label>
                                                                <div class="col-md-7">
                                                                        <select id="mySel" ng-model="heroEquipment.gloves"
                                                                                class="form-control">
                                                                                <option ng-repeat="glove in gloves" value="{{glove.id}}">{{glove.label}}</option>
                                                                        </select>
                                                                </div>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                                    <label class="col-md-2 control-label" for="file">Helmet</label>
                                                                    <div class="col-md-7">
                                                                            <select id="mySel" ng-model="heroEquipment.helmet"
                                                                                    class="form-control">
                                                                                    <option ng-repeat="helmet in helmets" value="{{helmet.id}}">{{helmet.label}}</option>
                                                                            </select>
                                                                    </div>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                                <label class="col-md-2 control-label" for="file">Main hand</label>
                                                                <div class="col-md-7">
                                                                        <select id="mySel" ng-model="heroEquipment.mainHand"
                                                                                class="form-control">
                                                                                <option ng-repeat="mainHand in mainHands" value="{{mainHand.id}}">{{mainHand.label}}</option>
                                                                        </select>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="row">
                                                        <div class="form-group form-group-lg">
                                                                    <label class="col-md-2 control-label" for="file">Off hand</label>
                                                                    <div class="col-md-7">
                                                                            <select id="mySel" ng-model="heroEquipment.offHand"
                                                                                    class="form-control">
                                                                                    <option ng-repeat="offHand in offHands" value="{{offHand.id}}">{{offHand.label}}</option>
                                                                            </select>
                                                                    </div>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                                <label class="col-md-2 control-label" for="file">MainArmor</label>
                                                                <div class="col-md-7">
                                                                        <select id="mySel" ng-model="heroEquipment.mainArmor"
                                                                                class="form-control">
                                                                                <option ng-repeat="mainArmor in mainArmors" value="{{mainArmor.id}}">{{mainArmor.label}}</option>
                                                                        </select>
                                                                </div>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                                <label class="col-md-2 control-label" for="file">Boots</label>
                                                                <div class="col-md-7">
                                                                        <select id="mySel" ng-model="heroEquipment.boots"
                                                                                class="form-control">
                                                                                <option ng-repeat="boots in bootsList" value="{{boots.id}}">{{boots.label}}</option>
                                                                        </select>
                                                                </div>
                                                        </div>
                                                    <div class="form-actions floatRight">
                                                            <input type="submit"
                                                                    value="save"
                                                                    class="btn btn-primary btn-sm">
                                                            <button type="button" ng-click="reset()"
                                                                    class="btn btn-warning btn-sm">Clear</button>
                                                    </div>
                                                </div>
                                            </form>
					</div>
				</div>
		    </md-content>  
		</div>
	</body>
</html>
