module.controller('userController', ['$scope', '$http', function($scope, $http){
	
	$scope.user ={
                firstname : '',
                lastname : '',
                login : '',
                password : ''
                };
    
    $scope.errors = {
        'login': '',
        'password': ''
    };
    
    $scope.genders = [];

    
    $http.get(prefix + '/user/profil/'+'jbednarczyk')
        .success(function(res){
            console.log('is user logged? ',res);
            $scope.userDetail = res;   
        })
        .error(function(error){
            console.log("Error after getting user " + error);
        });
    
    $scope.clear = function(){
        $scope.user ={
                firstname : '',
                lastname : '',
                login : '',
                password : '',
                heroesIds : []
                };
        $scope.errors = {
            'login': '',
            'password': ''
        };
    };
}]);