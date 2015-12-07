module.controller('userController', ['$scope', '$http', function($scope, $http){
    $scope.user = {}   
    $http.post('/user/login', $scope.user)
    .success(function(response){
        if(response.length>0) {
            angular.forEach(response, function(val){                                    
               if(val.field==='login'){
                   $scope.errors.login = val.defaultMessage;
               }
               if(val.field==='password'){
                   $scope.errors.password = val.defaultMessage;
               }
            });
        }
    })
    .error(function(error){
        console.log(error);
    });
}]);