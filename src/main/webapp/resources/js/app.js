'use strict';

// Define an angular module for our app
var module = angular.module("StarterApp", ['ngRoute']);

module.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/route1', {
                    templateUrl: '/hackandslash/register',
                    controller: 'registerController'
                }).
                when('/route2', {
                    templateUrl: '/hackandslash/login',
                    controller: 'loginController'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);

module('StarterApp', ['ngMaterial']);

module('StarterApp').controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
    $scope.isRegister = false;
    $scope.toggleSidenav = function(menuId) {
      $mdSidenav(menuId).toggle();
    };
    
    $scope.hero = function(){
      $scope.isRegister = false;
      $scope.isUser = false;
      $scope.isHeroAdd = false;
      $scope.isLogin = false;
      if(!$scope.isHero){
          $scope.isHero = true;   
      } else {
          $scope.isHero = false;
      }
      $mdSidenav('left').toggle();
    }
    
    $scope.login = function(){
        $scope.isRegister = false;
        $scope.isUser = false;
        $scope.isHero = false;
        $scope.isHeroAdd = false;
        if(!$scope.isLogin){
          $scope.isLogin = true;   
      } else {
          $scope.isLogin = false;
      }
      $mdSidenav('left').toggle();
    };
    
    $scope.user = function(){
      $scope.isRegister = false;
      $scope.isHero = false;
      $scope.isHeroAdd = false;
      $scope.isLogin = false;
      if(!$scope.isUser){
          $scope.isUser = true;   
      } else {
          $scope.isUser = false;
      }
      $mdSidenav('left').toggle();
    }
    $scope.register = function() {
      $scope.isUser = false;
      $scope.isHero = false;
      $scope.isHeroAdd = false;
      $scope.isLogin = false;
      if(!$scope.isRegister){
          $scope.isRegister = true;  
      } else {
          $scope.isRegister = false;
      }
      $mdSidenav('left').toggle();
    };
    
    $scope.heroAdd = function(){
        $scope.isRegister = false;
        $scope.isUser = false;
        $scope.isHero = false;
        $scope.isLogin = false;
        if(!$scope.isHeroAdd){
          $scope.isHeroAdd = true;  
      } else {
          $scope.isHeroAdd = false;
      }
      $mdSidenav('left').toggle();
    }
    // needs rebuilding to clear other bools then the one in parameter
    function clear(){
        $scope.isRegister = false;
        $scope.isUser = false;
        $scope.isHero = false;
        $scope.isHeroAdd = false;
        $scope.isLogin = false;
    }
  }]);

module('StarterApp').controller('registerController', ['$scope', '$http', function($scope, $http){
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
    
    $http.get('/hackandslash/users/'+'jbednarczyk')
        .success(function(res){
             $scope.userDetail = res;   
        })
        .error(function(error){
            console.log(error);
        })
    $http.get('/hackandslash/register/genderList')
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
        $http.post('/hackandslash/registerTest/addAngu', $scope.user).success(function(response) {//registerTest/add
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

module('StarterApp').controller('heroController', ['$scope', '$http', function($scope, $http){
    $scope.heroDetail = {}   
    $http.get('/hackandslash/hero/details')
    .success(function(response){
        $scope.heroDetail = response;
    })
    .error(function(error){
        console.log(error);
    });
}]);

module('StarterApp').controller('loginController', ['$scope', '$http', function($scope, $http){
    $scope.user = {}   
    $http.post('/hackandslash/user/login', $scope.user)
    .success(function(response){
        if(response.length>0) {
            angular.forEach(response, function(val){                                    
               if(val.field==='login'){
                   $scope.errors.login = val.defaultMessage;
               }
               if(val.field==='password'){
                   $scope.errors.password = val.defaultMessage;
               }
            });
        }
    })
    .error(function(error){
        console.log(error);
    });
}]);