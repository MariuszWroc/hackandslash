module.controller('userController', ['$scope', '$http', function($scope, $http){
    
	$scope.userDetail = {id:null, password:'', email:'', firstname:'', lastname:'', age:'', gender:0};
	
    $scope.genders = [
                      { id: 0, label: '' },
                      { id: 1, label: 'Male' },
                      { id: 2, label: 'Female' },
                      ];
    
    $http.get(prefix + '/user/actualProfil')
        .success(function(res){
            console.log('is user logged? ',res);
            $scope.userDetail = res;
        })
        .error(function(error){
            console.log('Error after getting user ' + error);
        });
        
    $scope.reset = function(){
            console.log('reset user register');
        };
        
    $scope.submit = function(){
    	console.log($scope.userDetail.gender);
    };

    
}]);