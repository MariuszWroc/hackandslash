module.controller('userController', ['$scope', '$http', function($scope, $http){
    
	$scope.userDetail = {};
	
	$scope.userRegister = {id:null, username:'', password:'', email:'', firstname:'', lastname:'', genders: [], age:''};
    
    $scope.genders = [
                      { id: 0, label: '' },
                      { id: 1, label: 'Male' },
                      { id: 2, label: 'Female' },
                      ];
    
    $scope.selectedGender = 0;
    
    $scope.doRegister = function (){
        $scope.errors = {
            'login': '',
            'password': ''
        };
        console.log('adding', $scope.userRegister);
        $http.post(prefix + "/register/add", $scope.userRegister)
        	.success(function(response) {
	            if(response.length>0) {
	                angular.forEach(response, function(val){
	                   if(val.field==='login'){
	                       $scope.errors.login = val.defaultMessage;
	                   }
	                   if(val.field==='password'){
	                       $scope.errors.password = val.defaultMessage;
	                   }
	                });
	            } else {
	                alert('registration successfull\n\
	                       You can now play the game');
	            }
	        })
	        .error(function(error) {
	        	console.log("Can't post user register, " + error);
	        });
    };
    
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
            $scope.userRegister = {id:null, username:'', password:'', email:'', firstname:'', lastname:'', genders: [], age:''};
            $scope.registerForm.$setPristine();
        };

    
}]);