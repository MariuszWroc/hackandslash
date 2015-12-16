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
						<input type="hidden" ng-model="userDetail.id" />
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Login</label>
								<div class="col-md-7">
									<input type="text"
										class="form-control input-sm"
										ng-model="userDetail.username" disabled="disabled"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Password</label>
								<div class="col-md-7">
									<input type="password" ng-model="userDetail.password"
										class="form-control input-sm"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Address e-mail</label>
								<div class="col-md-7">
									<input type="email" ng-model="userDetail.email"
										class="form-control input-sm"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Firstname</label>
								<div class="col-md-7">
									<input type="text" ng-model="userDetail.firstname"
										class="form-control input-sm"
										/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Lastname</label>
								<div class="col-md-7">
									<input type="text" ng-model="userDetail.lastname"
										class="form-control input-sm"
										/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Gender</label>
								<div class="col-md-7">
									<input type="text" ng-model="userDetail.gender"
										class="form-control input-sm"
										/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-md-12">
								<label class="col-md-2 control-lable" for="file">Age</label>
								<div class="col-md-7">
									<input type="number" min="7" max="99" ng-model="userDetail.age"
										class="form-control input-sm"
										/>
								</div>
							</div>
						</div>
						<div class="row">
	                          <div class="form-actions floatRight">
	                              <input type="submit"  value="Update" class="btn btn-primary btn-sm" >
	                              <button type="button" ng-click="reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Clear</button>
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