module.controller('registerController', ['$scope', '$http', '$window', function($scope, $http, $window){
    
	$scope.userRegister = {id:null, password:'', email:'', firstname:'', lastname:'', age:''};
    
    $scope.genders = [
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
                alert('registration successfull\n\
                       You can now play the game');
                $window.location.href = '#/welcome';
	        })
	        .error(function(error) {
                    if(error.length>0) {
	                angular.forEach(error, function(val){
	                   if(val.field==='login'){
	                       $scope.errors.login = val.defaultMessage;
	                   }
	                   if(val.field==='password'){
	                       $scope.errors.password = val.defaultMessage;
	                   }
	                });
	            }
                    alert('registration failed\n\
                    Please try again')
                    console.log("Can't post user register, " + error);
	        });
    };
    
    $scope.reset = function(){
            console.log('reset user register');
            $scope.userRegister = {id:null, username:'', password:'', email:'', firstname:'', lastname:'', age:''};
            $scope.registerForm.$setPristine();
        };

    
}]);