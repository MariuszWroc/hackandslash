module.controller('userController', ['$scope', '$http', function($scope, $http){

    $http.get(prefix + '/user/actualProfil')
        .success(function(res){
            console.log('is user logged? ',res);
            $scope.userDetail = res;   
        })
        .error(function(error){
            console.log("Error after getting user " + error);
        });

}]);