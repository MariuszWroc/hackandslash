module.controller('menuController', ['$scope', '$http', function($scope, $http){
    $scope.user = {}
    
    $scope.doRegister = function (){
        $scope.errors = {
            'login': '',
            'password': ''
        };
        console.log('adding',$scope.user);
        $http.post(prefix + '/registerTest/addAngu', $scope.user).success(function(response) {
            if(response.length>0) {
                angular.forEach(response, function(val){                                    
                   if(val.field==='login'){
                       $scope.errors.login = val.defaultMessage;
                   }
                   if(val.field==='password'){
                       $scope.errors.password = val.defaultMessage;
                   }
                   if(val.field==='email'){
                       $scope.errors.email = val.defaultMessage;
                   }
                });
            } else {
                alert('registration successfull\n\
                       You can now play the game');
            }
        }).error(function(error) {
            console.log(error);
        });
    };
    
    $http.get(prefix + '/register/genderList')
    .success(function(res) {
        $scope.genders = res;
    }).error(function(error) {
        alert(error);
    });
    
}]);