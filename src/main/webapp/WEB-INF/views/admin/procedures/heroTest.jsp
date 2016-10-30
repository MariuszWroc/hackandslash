<%-- 
    Document   : register
    Created on : Oct 31, 2015, 12:41:58 PM
    Author     : mariusz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert hero (register)</title>
<style>
.error {
	color: #000;
	background-color: #ffEEEE;
	border: 1px solid #ff0000;
}
</style>
</head>
<title>Hero creator</title>
</head>
<body onload="hideRow('profession_row');hideRow('attributes_row')">
	<script>window.onload = hideRow('profession_row');</script>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div align="center">
		<h2>Hero creator</h2>
		<c:url var="addAction" value="/admin/heroTest/add"></c:url>
		<form:form id="heroForm" method="POST" action="${addAction}"
			commandName="hero">
			<table>
				<tr>
					<td>
						<table>
							<tr>
								<td><form:label path="firstname">
										<spring:message text="First name" />
									</form:label></td>
								<td><form:input path="firstname" /></td>
								<td><form:errors path="firstname" cssclass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="lastname">
										<spring:message text="Last name" />
									</form:label></td>
								<td><form:input path="lastname" /></td>
							</tr>
							<tr>
								<td><form:label path="gender">
										<spring:message text="Gender" />
									</form:label></td>
								<td><form:select path="gender">
										<form:option value="" />
										<form:options items="${genderEnum}" itemLabel="name"
											itemValue="id" />
									</form:select></td>
							</tr>
							<tr>
								<td><form:label path="age">
										<spring:message text="Age" />
									</form:label></td>
								<td><form:input path="age" type="number" min="1" /></td>
								<td><form:errors path="age" cssclass="error" /></td>
							</tr>
							<tr>
								<td><form:label path="race">
										<spring:message text="Race" />
									</form:label></td>
								<td><form:select id="raceCombobox" path="race"
										onchange="showRow('profession_row')">
										<form:option value="" />
										<form:options items="${raceEnum}" itemLabel="name"
											itemValue="id" />
									</form:select></td>
							</tr>
							<tr id="profession_row">
								<td><form:label path="profession">
										<spring:message text="Profession" />
									</form:label></td>
								<td><form:select path="profession"
										onchange="showRow('attributes_row')">
										<form:option value="" />
										<form:options items="${professionEnum}" itemLabel="name"
											itemValue="id" />
									</form:select></td>
							</tr>
						</table>
						<table id="attributes_row">
							<tr>
								<td><form:label path="strength">
										<spring:message text="Strength" />
									</form:label></td>
								<td><form:input path="strength" type="number"
										value="${strength}" min="${minStrength}" max="${maxStrength}" />
								</td>
							</tr>
							<tr>
								<td><form:label path="dexterity">
										<spring:message text="Dexterity" />
									</form:label></td>
								<td><form:input path="dexterity" type="number"
										value="${dexterity}" min="${minDexterity}"
										max="${maxDexterity}" /></td>
							</tr>
							<tr>
								<td><form:label path="constitution">
										<spring:message text="Constitution" />
									</form:label></td>
								<td><form:input path="constitution" type="number"
										value="${constitution}" min="${minConstitution}"
										max="${maxConstitution}" /></td>
							</tr>
							<tr>
								<td><form:label path="intelligence">
										<spring:message text="Intelligence" />
									</form:label></td>
								<td><form:input path="intelligence" type="number"
										value="${intelligence}" min="${minIntelligence}"
										max="${maxIntelligence}" /></td>
							</tr>
							<tr>
								<td><form:label path="startingPoints">
										<spring:message text="Attributes points" />
									</form:label></td>
								<td><form:input path="startingPoints" readonly="true"
										disabled="true" /></td>
							</tr>
							<tr>
								<td><input type="submit" value="Roll again" /></td>

							</tr>
							<tr>
								<td colspan="2"><input type="submit" value="Add" /> <input
									type="reset" value="Clear" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
	<div align="left">
		<p>
			<a href="${contextPath}/admin/panel">powrót</a>
		</p>
	</div>
	<script>
			function showRow(rowId) {
			    document.getElementById(rowId).style.display = "";
			}
			function hideRow(rowId) {
			    document.getElementById(rowId).style.display = "none";
			}
		</script>
</body>
</html>