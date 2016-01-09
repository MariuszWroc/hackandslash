module.controller('DialogController', function($scope, $mdDialog, locals) {
	$scope.fromUserProfile = locals.fromUserProfile;
    $scope.hide = function() {
      $mdDialog.hide();
    };

    $scope.cancel = function() {
        console.log('dialog canceled');
        $mdDialog.cancel();
    };

    $scope.answer = function(answer) {
      $mdDialog.hide(answer);
    };
});


