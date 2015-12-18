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
		<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css"/>
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
	<div ng-controller="userController" flex id="content" ng-cloak class="ng-cloak">
		<md-content layout="column" flex class="md-padding">
		<div id="profil">
			<div class="formcontainer">
				<form ng-submit="submit()" name="userForm" class="form-horizontal">
					<input type="hidden" ng-model="userDetail.id" />
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputLogin"><span class="pull-left">Login</span></label>
							<div class="col-md-7">
								<input id="inputLogin" type="text"
									ng-model="userDetail.username" class="form-control input-sm"
									disabled="disabled">
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.username" class="error">{{errors.username}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputPassword"><span class="pull-left">Password</span></label>
							<div class="col-md-7">
								<input id="inputPassword" type="password"
									ng-model="userDetail.password" class="form-control input-sm" />
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.username" class="error">{{errors.username}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputEmail"><span class="pull-left">Address
									e-mail</span></label>
							<div class="col-md-7">
								<input id="inputEmail" type="email" ng-model="userDetail.email"
									class="form-control input-sm" />
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.username" class="error">{{errors.username}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputFirstname"><span class="pull-left">Firstname</span></label>
							<div class="col-md-7">
								<input id="inputFirstname" type="text"
									ng-model="userDetail.firstname" class="form-control input-sm" />
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.username" class="error">{{errors.username}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputLastname"><span class="pull-left">Lastname</span></label>
							<div class="col-md-7">
								<input id="inputLastname" type="text"
									ng-model="userDetail.lastname" class="form-control input-sm" />
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.username" class="error">{{errors.lastname}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputAge"><span class="pull-left">Age</span></label>
							<div class="col-md-7">
								<input id="inputAge" type="number" min="7" max="99"
									ng-model="userDetail.age" class="form-control input-sm" />
							</div>
							<div class="has-error" ng-show="userForm.$dirty">
								<span ng-show="errors.age" class="error">{{errors.username}}</span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group form-group-lg">
							<label id="form-label" class="col-md-2 control-label"
								for="inputGender"><span class="pull-left">Gender</span></label>
							<div class="col-md-7">
								<select id="mySel" class="form-control">
          							<option ng-repeat="gender in genders" ng-selected="selectedGender" ng-model="gender.id">{{gender.label}}</option>
        						</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="Update"
								class="btn btn-primary btn-sm">
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="logout">
					<c:url var="logoutUrl"
						value="${contextPath}/j_spring_security_logout" />
					<c:set var="contextPath" value="${pageContext.request.contextPath}" />
					<!-- csrt for log out-->
					<form action="<c:url value='/j_spring_security_logout' />"
						method="post" id="logoutForm">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
	
					<script>
							function formSubmit() {
								document.getElementById("logoutForm").submit();
							}
						</script>
	
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<h2>
							Welcome : ${pageContext.request.userPrincipal.name} | <a
								href="javascript:formSubmit()"> Logout</a>
						</h2>
					</c:if>
				</div>
			</md-content>
		</div>
</body>
</html>