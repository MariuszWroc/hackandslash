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
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="heroController" flex id="content">
		    <md-content layout="column" flex class="md-padding">
		    	<div id="heroProfil" class="panel panel-default">
		    		<div class="panel-heading">
		    			<span class="lead">Hero Management Form </span>
		    		</div>
					<div class="formcontainer">
						<form ng-submit="submit()" method="post" name="heroForm" class="form-horizontal">
							<input type="hidden" ng-model="heroDetail.id" />
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Firstname</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.firstname" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Lastname</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.lastname" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Gender</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.gender" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Age</label>
									<div class="col-md-7">
										<input type="number" min="18" max="99"
											class="form-control input-sm"
											ng-model="heroDetail.age" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Race</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.race" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Profession</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.profession" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Strength</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.strength" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Dexterity</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.dexterity" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Constitution</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.constitution" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Intelligence</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.intelligence" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Charisma</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.charisma" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">BaseHp</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.baseHp" input-sm"/>
									</div>
								</div>
							</div>
						<div class="row">
	                          <div class="form-actions floatRight">
	                          	  <input type="submit"  value="{{!heroDetail.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" >
	                          	  <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="heroForm.$pristine">Clear</button>
	                          </div>
	                     </div>
	            	</form>
					</div>
				</div>
				<div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Heroes </span></div>
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
                              <button type="button" ng-click="editUser()" class="btn btn-success custom-width">Edit</button>  
                              <button type="button" ng-click="deleteUser()" class="btn btn-danger custom-width">Remove</button>
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