module.controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {};
    $scope.heroes = [];
    
    $http.get(prefix + '/user/actualHero')
        .success(function(response){
        console.log('Fetching hero success ', response);
            $scope.heroDetail = response;
        })
        .error(function(error){
            console.log("Error after getting hero. ", error);
        });
    
    $http.get(prefix + '/user/hero/getAll')
	    .success(function(response){
	    console.log('Fetching hero success ', response);
	        $scope.heroes = response;
	    })
	    .error(function(error){
	        console.log("Error after getting hero. ", error);
	    });
    
    $scope.editHero = function(){
    	$http.put("user/hero/edit/"+$scope.heroDetail.id, $scope.heroDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.heroDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    };
    
    $scope.deleteHero = function(){
    	$http.delete("user/hero/delete/" + $scope.heroDetail.id)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.heroDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    };
            
    $scope.reset = function(){
        $scope.heroDetail = {};
    };
}]);