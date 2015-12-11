module.controller('registerController', ['$scope', '$http', function($scope, $http){
        var prefix = 'http://localhost:8084/hackandslash/';
    $scope.user ={
                firstname : '',
                lastname : '',
                login : '',
                password : ''
                };
    $scope.userDetail ={
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
    console.log('getting user: jbednarczyk)');
    $http.get(prefix + '/user/'+'jbednarczyk')
        .success(function(res){
            console.log('getting user:',res);
            $scope.userDetail = res;   
        })
        .error(function(error){
            console.log(error);
        });
    $http.get(prefix + 'register/genderList')
        .success(function(res) {
            $scope.genders = res;
        }).error(function(error) {
            alert(error);
        }); 
    $scope.doRegister = function (){
        $scope.errors = {
            'login': '',
            'password': ''
        };
        console.log('adding',$scope.user);
        $http.post(prefix + 'registerTest/addAngu', $scope.user).success(function(response) {//registerTest/add
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