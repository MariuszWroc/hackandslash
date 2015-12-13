module.controller('userController', ['$scope', '$http', function($scope, $http){
        var prefix = '/hackandslash/';
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
    console.log('before get user');
    
    $http.get(prefix + '/user/profil'+'jbednarczyk')
        .success(function(res){
            console.log('getting user:',res);
            $scope.userDetail = res;   
        })
        .error(function(error){
            console.log("Error after getting user " + error);
        });
    
    $http.get(prefix + '/user/hero'+'jbednarczyk')
    .success(function(res){
        console.log('getting user:',res);
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