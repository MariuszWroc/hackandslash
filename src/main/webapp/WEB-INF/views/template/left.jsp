<div layout="row" flex>
	<md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2"
		md-component-id="left"> <md-toolbar layout="row">
	<div class="md-toolbar-tools">
		<h2>
			<span>Side Panel</span>
		</h2>
		<md-button ng-click="toggleSidenav('left')" class="md-icon-button">
		<md-tooltip>Click for close</md-tooltip> <md-icon aria-label="Menu"
			md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg" />
		</md-button>
	</div>
	</md-toolbar> <md-content layout-padding=""> <md-button md-raised
		md-primary layout-fill href="#/user/profil">Profil</md-button> <md-button
		md-raised md-primary layout-fill href="#user/hero">Heroes</md-button> </md-content> </md-sidenav>
</div>