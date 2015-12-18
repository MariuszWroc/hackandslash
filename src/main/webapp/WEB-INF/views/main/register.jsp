<%-- 
    Document   : Profl
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
		<div ng-controller="userController" flex id="content" ng-cloak class="ng-cloak">
			<md-content layout="column" flex class="md-padding">
				<div id="profil">
					<div class="formcontainer">
						<form ng-submit="submit()" name="userForm"
							class="form-horizontal">
							<input type="hidden" ng-model="userRegister.id" />
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputLogin">Login</label>
									<div class="col-md-7">
										<input id="inputLogin" type="text" ng-model="userRegister.username"
											class="form-control input-sm" >
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputPassword">Password</label>
									<div class="col-md-7">
										<input id="inputPassword" type="password" ng-model="userRegister.password"
											class="form-control input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputEmail">Address e-mail</label>
									<div class="col-md-7">
										<input id="inputEmail" type="email" ng-model="userRegister.email"
											class="form-control input-sm"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputFirstname">Firstname</label>
									<div class="col-md-7">
										<input id="inputFirstname" type="text" ng-model="userRegister.firstname"
											class="form-control input-sm"
											/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputLastname">Lastname</label>
									<div class="col-md-7">
										<input id="inputLastname" type="text" ng-model="userRegister.lastname"
											class="form-control input-sm"
											/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
								    <label class="col-md-2 control-label" for="inputGender">Gender</label>
									<div class="col-md-7">
										<md-select class="form-control input-sm" ng-model="selectedGender">
											<md-option  ng-value="gender.id" ng-repeat="gender in genders">{{gender.label}}</md-option>
										</md-select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="inputAge">Age</label>
									<div class="col-md-7">
										<input id="inputAge" type="number" min="7" max="99" ng-model="userRegister.age"
											class="form-control input-sm"
											/>
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