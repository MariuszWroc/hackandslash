<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div ng-controller="emailController" flex id="content" ng-cloak
			class="ng-cloak">
			<md-content layout="column" flex class="md-padding">
				<div id="email" class="panel panel-default">
					<div class="panel-heading">
						<span class="lead">Contact us</span>
					</div>
					<div class="formcontainer">
						<form ng-submit="sendEmail()" method="post" name="emailForm" class="form-horizontal">
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">From</label>
									<div class="col-md-7">
										<input type="email" class="form-control input-sm"
											ng-model="emailDetail.sender" required="required"/>									
									</div>								
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Subject</label>
									<div class="col-md-7">
										<input type="text" class="form-control input-sm"
											ng-model="emailDetail.subject" required="required"/>									
									</div>								
								</div>
							</div>
							<div class="row">
								<div class="form-group form-group-lg">
									<label class="col-md-2 control-label" for="file">Content</label>
									<div class="col-md-7">
										<textarea rows="10" class="form-control input-sm"
											ng-model="emailDetail.body" required="required"></textarea>
									</div>								
								</div>
							</div>
							<div class="row">
	                        	<div class="form-actions floatRight">
	                            	<input type="submit"  value="Send E-mail" class="btn btn-primary btn-sm" >
	                            	<button type="button" ng-click="reset()" class="btn btn-warning btn-sm" >Clear</button>
	                        	</div>								
							</div>
						</form>
					</div>
				</div>
			</md-content>
		</div>
	</body>
</html>
