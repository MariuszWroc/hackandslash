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
					<div class="formcontainer" layout="row">
                                            <form ng-submit="saveEquipment()" method="post" name="equipmentForm"class="form-horizontal" flex="50">
                                                <div class="row">
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Gloves</label>
                                                                <input ng-disabled="true" style="color:black;"  ng-model="heroEquipment.gloves.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Headgear</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.headgear.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Right hand</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.rightHand.label"/>
                                                            </md-input-container>
                                                        </div>
                                                </div>
                                                <div class="row">
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Left hand</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.leftHand.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Armor</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.armor.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Boots</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.boot.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Left ring</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.leftRing.label"/>
                                                            </md-input-container>
                                                        </div>
                                                        <div class="form-group form-group-lg">
                                                            <md-input-container>
                                                                <label class="col-md-2 control-label" style="color:black;" for="file">Right ring</label>
                                                                <input ng-disabled="true" style="color:black;" ng-model="heroEquipment.righRring.label"/>
                                                            </md-input-container>
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
                                            <div class="tablecontainer">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Select items to display</label>
                                                            <div class="col-md-7">
                                                                <select id="mySel" ng-change="filterTable()" ng-model="filterType" class="form-control">
                                                                    <option value="all">All</option>
                                                                    <option value="gloves">Gloves</option>
                                                                    <option value="headgear">Headgear</option>
                                                                    <option value="boot">Boots</option>
                                                                    <option value="leftHand">Left hand</option>
                                                                    <option value="rightHand">Right hand</option>
                                                                    <option value="righRring">Right ring</option>
                                                                    <option value="leftRing">Left ring</option>
                                                                    <option value="armor">Armor</option>
                                                                </select>
                                                            </div>
                                                    </div>
                                                    <table class="table table-hover">
                                                            <thead>
                                                                    <tr>
                                                                            <th>Name</th>
                                                                            <th>Type</th>
                                                                            <th width="20%"></th>
                                                                    </tr>
                                                            </thead>
                                                            <tbody>
                                                                    <tr ng-repeat="eq in backpackItems">
                                                                            <td>{{eq.label}}</td>
                                                                            <td>{{eq.type}}</td>
                                                                            <td>
                                                                                    <button type="button" ng-click="selectItem(eq)"
                                                                                            class="btn btn-success custom-width">Select</button>
                                                                            </td>
                                                                    </tr>
                                                            </tbody>
                                                    </table>
                                            </div>
					</div>
				</div>
		    </md-content>  
		</div>
	</body>
</html>
