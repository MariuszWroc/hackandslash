module.controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {}   
    $http.get('/hero/details')
    .success(function(response){
        $scope.heroDetail = response;
    })
    .error(function(error){
        console.log(error);
    });
}]);