<%-- 
    Document   : ShowUsers
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
		<div ng-controller="heroController" flex id="content" ng-cloak class="ng-cloak">
		    <md-content layout="column" flex class="md-padding">
		    	<div id="heroProfil">
					<div class="formContainer">
						<form ng-submit="submit()" name="userForm" class="form-horizontal">
							<input type="hidden" ng-model="heroDetail.id" />
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Firstname</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.firstname" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Lastname</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.lastname" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Gender</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.gender" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Age</label>
									<div class="col-md-7">
										<input type="number" min="18" max="99"
											class="form-control input-sm"
											ng-model="heroDetail.age" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Race</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.race" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Profession</label>
									<div class="col-md-7">
										<input type="text"
											class="form-control input-sm"
											ng-model="heroDetail.profession" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Strength</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.strength" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Dexterity</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.dexterity" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Constitution</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.constitution" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Intelligence</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.intelligence" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">Charisma</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.charisma" input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-lable" for="file">BaseHp</label>
									<div class="col-md-7">
										<input type="number"
											class="form-control input-sm"
											ng-model="heroDetail.baseHp" input-sm"/>
									</div>
								</div>
							</div>
						<div class="row">
	                          <div class="form-actions floatRight">
	                              <input type="submit"  value="Create" class="btn btn-primary btn-sm" >
	                              <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Clear</button>
	                          </div>
	                     </div>
	            	</form>
					</div>
				</div>
		    </md-content>  
		</div>
	</body>
</html>