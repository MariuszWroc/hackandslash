<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<c:url var="logoutUrl" value="${contextPath}/j_spring_security_logout" />
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<!-- csrt for log out-->
		<div id="logout">
			<!-- csrt for log out-->
			<c:url var="addAction" value="/j_spring_security_logout"/>
			<form action="${addAction}" method="POST" id="logoutForm" accept-charset="UTF-8">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<div id="logoutButton">
					<input name="submit" type="submit"
		                    value="logout" />
				</div>
			</form>
			
			
		</div>

</body>
</html>