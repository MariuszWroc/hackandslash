module.controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {};
    
    $http.get(prefix + '/user/actualHero')
        .success(function(response){
        console.log('Fetching hero success ', response);
            $scope.heroDetail = response;
        })
        .error(function(error){
            console.log("Error after getting hero. ", error);
        });
            
    $scope.reset = function(){
        $scope.heroDetail = {};
    };
}]);