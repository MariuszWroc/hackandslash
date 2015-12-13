module.controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {}   
    $http.get('/hero/detailsxxx')
    .success(function(response){
        $scope.heroDetail = response;
    })
    .error(function(error){
        console.log(error);
    });
}]);