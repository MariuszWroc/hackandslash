<%-- 
    Document   : ShowHeroes
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css"
	href="${contextPath}/resources/css/common.css">
</head>
<body ng-cloak class="ng-cloak">
	<div ng-controller="heroController" flex id="content">
		<md-content layout="column" flex class="md-padding">
		<div id="heroProfil" class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Hero Management Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="submit()" method="post" name="heroForm"
					class="form-horizontal">
                                    <md-tabs md-dynamic-height md-border-bottom md-center-tabs="true" md-selected="tabIndex">
                                        <md-tab label="General info" ng-disabled="disableFirstStep">
                                            <input type="hidden" ng-model="heroDetail.id" />
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Firstname</label>
                                                            <div class="col-md-7">
                                                                    <input type="text" class="form-control input-sm"
                                                                            ng-model="heroDetail.firstname" />
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.firstname" class="help-block">{{errors.firstname}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Lastname</label>
                                                            <div class="col-md-7">
                                                                    <input type="text" class="form-control input-sm"
                                                                            ng-model="heroDetail.lastname" />
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Gender</label>
                                                            <div class="col-md-7">
                                                                    <select id="mySel" ng-model="heroDetail.gender"
                                                                            class="form-control">
                                                                            <option ng-repeat="gender in genders"
                                                                                    ng-selected="heroDetail.gender==gender.id"
                                                                                    value="{{gender.id}}">{{gender.label}}</option>
                                                                    </select>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Age</label>
                                                            <div class="col-md-7">
                                                                    <input type="number" min="18" max="99"
                                                                            class="form-control input-sm" ng-model="heroDetail.age" />
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.age" class="help-block">{{errors.age}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Race</label>
                                                            <div class="col-md-7">
                                                                    <select ng-disabled="heroDetail.id" id="mySel" ng-model="heroDetail.race"
                                                                            class="form-control" ng-disabled="heroDetail.age<=0">
                                                                            <option ng-repeat="race in races"
                                                                                    ng-selected="heroDetail.race==race.id" value="{{race.id}}">{{race.label}}</option>
                                                                    </select>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
						<div class="form-group form-group-lg">
							<label class="col-md-2 control-label" for="file">Profession</label>
							<div class="col-md-7">
								<select ng-disabled="heroDetail.id" id="mySel" ng-model="heroDetail.profession"
									class="form-control" ng-disabled="!heroDetail.race">
									<option ng-repeat="profession in proffesions" 
										ng-selected="heroDetail.profession==profession.id"
										value="{{profession.id}}">{{profession.label}}</option>
								</select>
							</div>
						</div>
                                            </div>
                                            <input  ng-disabled="!heroDetail.id"
                                                    type="submit"
                                                    value="Update"
                                                    class="btn btn-primary btn-sm floatRight">
                                            <button type="button" ng-click="reset()"
                                                    class="btn btn-warning btn-sm floatRight" ng-disabled="heroForm.$pristine">Clear</button>
                                            <button type="button" ng-click="next(tabIndex)"
                                                                    class="btn btn-warning btn-sm floatRight">Next</button>
                                        </md-tab>
                                        <md-tab label="Atributes" ng-disabled="disableSecondStep">
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Strength</label>
                                                            <div class="col-md-7">
                                                                    <input ng-disabled="heroDetail.id" type="number" class="form-control input-sm" ng-disabled="!heroDetail.race"
                                                                            ng-model="heroDetail.strength"/>
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.strength" class="help-block">{{errors.strength}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Dexterity</label>
                                                            <div class="col-md-7">
                                                                    <input ng-disabled="heroDetail.id" type="number" class="form-control input-sm" ng-disabled="!heroDetail.race"
                                                                            ng-model="heroDetail.dexterity"/>
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.dexterity" class="help-block">{{errors.dexterity}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Constitution</label>
                                                            <div class="col-md-7">
                                                                    <input ng-disabled="heroDetail.id" type="number" class="form-control input-sm" ng-disabled="!heroDetail.race"
                                                                            ng-model="heroDetail.constitution"/>
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.constitution" class="help-block">{{errors.constitution}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <div class="row">
                                                    <div class="form-group form-group-lg">
                                                            <label class="col-md-2 control-label" for="file">Intelligence</label>
                                                            <div class="col-md-7">
                                                                    <input ng-disabled="heroDetail.id" type="number" class="form-control input-sm" ng-disabled="!heroDetail.race"
                                                                            ng-model="heroDetail.intelligence"/>
                                                            </div>
                                                            <div class="has-error" ng-show="heroForm.$dirty">
                                                                    <label ng-show="errors.intelligence" class="help-block">{{errors.intelligence}}
                                                                    </label>
                                                            </div>
                                                    </div>
                                            </div>
                                            <button type="button" ng-click="goBack()"
                                                                    class="btn btn-warning btn-sm floatLeft">Back</button>
                                            <div class="row" ng-show="tabIndex==1">
                                                    <div class="form-actions floatRight">
                                                            <input type="submit"
                                                                    value="{{!heroDetail.id ? 'Add' : 'Update'}}"
                                                                    class="btn btn-primary btn-sm">
                                                            <button type="button" ng-click="reset()"
                                                                    class="btn btn-warning btn-sm" ng-disabled="heroForm.$pristine">Clear</button>
                                                    </div>
                                            </div>
                                        </md-tab>
                                    </md-tabs>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">List of Heroes </span>
                                <button type="button" ng-click="initializeHero()"
                                                                    class="btn btn-success btn-sm floatRight">Create new</button>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID.</th>
							<th>Name</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="one_hero in heroes">
							<td><span ng-bind="one_hero.id"></span></td>
							<td><span ng-bind="one_hero.firstname"></span></td>
							<td>
								<button type="button" ng-click="loadHero(one_hero.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="deleteHero()"
									class="btn btn-danger custom-width">Remove</button>
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