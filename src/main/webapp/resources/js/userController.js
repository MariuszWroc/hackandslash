module.controller('userController', ['$scope', '$http', '$mdDialog', function($scope, $http, $mdDialog){
    
    $scope.userDetail = {id:null, password:'', email:'', firstname:'', lastname:'', age:''};
	
    $scope.genders = [
                      { id: 1, label: 'Male' },
                      { id: 2, label: 'Female' },
                      ];
                      
    $scope.errors = {};
                      
    function getUserData() {
        $http.get(prefix + '/user/actualProfil')
	        .success(function(res){
	            console.log('is user logged? ',res);
	            $scope.userDetail = res;
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    }
    
    getUserData();
    
    $scope.reset = function(){
        getUserData();
        console.log('reset user register');
    };
        
    $scope.editUser = function(){
    	$http.put("user/edit/"+$scope.userDetail.id, $scope.userDetail)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            getUserData();
	        })
	        .error(function(error){
                    if(error.length>0) {
	                angular.forEach(error, function(val){
	                   if(val.field==='login'){
	                       $scope.errors.login = val.defaultMessage;
	                   }
	                   if(val.field==='password'){
	                       $scope.errors.password = val.defaultMessage;
	                   }
                           if(val.field==='email'){
	                       $scope.errors.password = val.defaultMessage;
	                   }
	                });
	            } else {
                        console.log("Can't post user register, " + error);
                    }
                    getUserData();
	        });
    };
    
    $scope.deleteUser = function(ev){
    	$http.delete("user/delete/" + $scope.userDetail.id)
	    	.success(function(res){
	            console.log('is user logged? ',res);
	            $scope.userDetail = res;
	            var locals = {'fromUserProfile':true};
	            $mdDialog.show({
	    	    	templateUrl: prefix + '/logout',
	    	        parent: angular.element(document.querySelector('#container')),
	    	        targetEvent: ev,
	    	        plain: true,
	    	        locals: locals,
	                controller: 'DialogController',
	                // perform delete operation
	                }, function (value) {
	                    //Do something 
	                });
	        })
	        .error(function(error){
	            console.log('Error after getting user ' + error);
	        });
    };

    
}]);