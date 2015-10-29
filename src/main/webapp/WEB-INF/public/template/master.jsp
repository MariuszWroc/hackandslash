<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="pl-PL" id="ng-app" ng-app="">
<head>
        <title><spring:message  code="project.title" /></title>
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />
 
            <tiles:insertAttribute name="body" />
        </div>
 
        <tiles:insertAttribute name="footer" />
    </body>
</html>
