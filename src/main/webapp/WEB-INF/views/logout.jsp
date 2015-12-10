<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>

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

</body>
</html>