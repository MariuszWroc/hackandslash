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
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/home.css">
	</head>
	<body>
		<div ng-controller="userController" flex id="content" ng-cloak class="ng-cloak">
		    <md-content layout="column" flex class="md-padding">
		    	<div id="profil">
			        <table style="width:100%">
			            <tr>
			              <td>
			              	<label>Firstname</label>
			              </td>
			              <td>{{userDetail.firstname}}</td>
			            </tr>
			            <tr>
			              <td>
			              	<label>Lastname</label>
			              </td>
			              <td>{{userDetail.lastname}}</td>
			            </tr>
			            <tr>
			              <td>
			              	<label>Login</label>
			              </td>
			              <td>{{userDetail.login}}</td>
			            </tr>
			            <tr>
			              <td>
			              	<label>Age</label>
			              </td>
			              <td>{{userDetail.age}}</td>
			            </tr>
			            <tr>
			              <td>
			              	<label>Gender</label>
			              </td>
			              <td>{{userDetail.gender}}</td>
			            </tr>
			        </table>
		        </div>
		        <div id="logout">
		        	<c:url var="logoutUrl" value="${contextPath}/j_spring_security_logout" />
				    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
					<!-- csrt for log out-->
					<form action="<c:url value='/j_spring_security_logout' />" method="post" id="logoutForm">
					  <input type="hidden" 
						name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					</form>
					
					<script>
						function formSubmit() {
							document.getElementById("logoutForm").submit();
						}
					</script>
				
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<h2>
							Welcome : ${pageContext.request.userPrincipal.name} | 
							<a href="javascript:formSubmit()"> Logout</a>
						</h2>
					</c:if>
		        </div>
		    </md-content>  
		</div>
	</body>
</html>