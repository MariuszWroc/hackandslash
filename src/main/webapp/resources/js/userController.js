module.controller('userController', ['$scope', '$http', function($scope, $http){
    
    $scope.userDetail = {};
    
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