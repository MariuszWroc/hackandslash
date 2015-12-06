module.controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
    $scope.toggleSidenav = function() {
    	$mdSidenav('left').toggle();
    };
  }]);
