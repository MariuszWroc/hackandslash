module.controller('emailController', ['$scope', '$http', function($scope, $http){
	$scope.emailDetail = {sender:'' , subject:'', body:''};
	
//    $http.send(prefix + '/email/send')
//	    .success(function(response){
//	    console.log('Sending email success ', response);
//	        $scope.emailDetail = response;
//	    })
//	    .error(function(error){
//	        console.log("Error after sending email. ", error);
//	    });
    
    $scope.reset = function(){
        console.log('reset email form');
    	$scope.emailDetail = {sender:'' , subject:'', body:''};
        $scope.emailForm.$setPristine();
    };	
}]);
