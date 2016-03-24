<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<c:set var="contextPath" value="${pageContext.request.contextPath}" />
		<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/common.css">
	</head>
	<body ng-cloak class="ng-cloak">
		<div layout="row" flex >
			<md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2" md-component-id="left"> 
				<md-toolbar layout="row">
					<div class="md-toolbar-tools">
						<h2>
							<span>Side Panel</span>
						</h2>
						<md-button ng-click="toggleSidenav('left')" class="md-icon-button">
						<md-tooltip>Click for close</md-tooltip> <md-icon aria-label="Menu"
							md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg" />
						</md-button>
					</div>
				</md-toolbar> 
				<md-content layout-padding="" style="height:100%"> 
					<md-button md-raised md-primary layout-fill href="#/user/profil">Profil</md-button> 
					<md-button md-raised md-primary layout-fill href="#/user/hero">Heroes</md-button> 
                                        <div class="dropdown">
                                            <md-button layout-fill class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Play
                                                <span class="caret"></span>
                                            </md-button>
                                            <ul class="dropdown-menu" style="width:100%">
                                              <li><md-button layout-fill href="#/user/game">New game</md-button></li>
                                              <li><md-button layout-fill href="#/user/combat">Battle</md-button></li>
                                              <li><md-button layout-fill href="#/user/equipment">Equipment</md-button></li>
                                              <li><md-button layout-fill href="#/user/journal">Journal</md-button></li>
                                              <li><md-button layout-fill href="#/user/shop">Shop</md-button></li>                
                                            </ul>
                                        </div>
				</md-content> 
			</md-sidenav>
		</div>
	</body>
</html>