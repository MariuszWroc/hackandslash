module.controller('userController', ['$scope', '$http', function($scope, $http){
    
    $scope.userDetail = {};
    
    $scope.genders = [
                      { 'id': 1, 'label': 'Male' },
                      { 'id': 2, 'label': 'Female' },
                      ];
    
    $scope.selectedGender = $scope.genders[0].id;
    
    $http.get(prefix + '/user/actualProfil')
        .success(function(res){
            console.log('is user logged? ',res);
            $scope.userDetail = res;   
        })
        .error(function(error){
            console.log("Error after getting user " + error);
        });
        
        $scope.reset = function(){
            console.log('test');
            $scope.userDetail = {};
        };
}]);