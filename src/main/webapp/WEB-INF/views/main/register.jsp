<%-- 
    Document   : Profl
    Created on : Nov 28, 2015, 8:13:58 PM
    Author     : Jaca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body flex id="content" ng-cloak>
		<div ng-controller="registerController">
			<md-content layout="column" flex class="md-padding">
				<div id="register" class="panel panel-default">
					<div class="panel-heading">
		    			<span class="lead">Register Form </span>
		    		</div>
					<div class="formcontainer">
						<form ng-submit="doRegister()" data-toggle="validator" method="post" name="registerForm" id="registerForm" class="form-horizontal">
							<input type="hidden" ng-model="userRegister.id" />
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputLogin"><span class="pull-left">Login</span></label>
									<div class="col-md-7">
										<input id="inputLogin" type="text" ng-model="userRegister.login"
											class="form-control input-sm" >
										<div class="has-error" ng-show="registerForm.$dirty">
											<label ng-show="errors.login" class="help-block" >{{errors.login}} </label>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputPassword"><span class="pull-left">Password</span></label>
									<div class="col-md-7" >
										<input id="inputPassword" type="password" ng-model="userRegister.password"
											class="form-control input-sm"/>
										<div class="has-error" ng-show="registerForm.$dirty">
											<label ng-show="errors.password" class="help-block">{{errors.password}} </label>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputEmail"><span class="pull-left">Address e-mail</span></label>
									<div class="col-md-7">
										<input id="inputEmail" type="email" ng-model="userRegister.email"
											class="form-control input-sm"/>
									</div>
									<div class="has-error" ng-show="registerForm.$dirty">
										<label ng-show="errors.email" class="help-block" >{{errors.email}} </label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputFirstname"><span class="pull-left">Firstname</span></label>
									<div class="col-md-7">
										<input id="inputFirstname" type="text" ng-model="userRegister.firstname"
											class="form-control input-sm"
											/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputLastname"><span class="pull-left">Lastname</span></label>
									<div class="col-md-7">
										<input id="inputLastname" type="text" ng-model="userRegister.lastname"
											class="form-control input-sm"
											/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label"
										for="inputGender"><span class="pull-left">Gender</span></label>
									<div class="col-md-7">
										<select id="mySel" class="form-control">
											<option></option>
		          							<option ng-repeat="gender in genders" ng-model="gender.id">{{gender.label}}</option>
		        						</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label id="form-label" class="col-md-2 control-label" for="inputAge"><span class="pull-left">Age</span></label>
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
		                              <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="registerForm.$pristine">Clear</button>
		                          </div>
		                     </div>
		            	</form>
						</div>
					</div>
				</md-content>
			</div>
	</body>
</html>

