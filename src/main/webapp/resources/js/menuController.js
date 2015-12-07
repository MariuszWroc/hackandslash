module.controller('menuController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {}   
    $http.get('/hero/about')
    .success(function(response){
        $scope.heroDetail = response;
    })
    .error(function(error){
        console.log(error);
    });
}]);