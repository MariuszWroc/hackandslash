<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en" ng-app="StarterApp">
  <head>
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=RobotoDraft:300,400,500,700,400italic">
    <style>
    	.md-toolbar-tools h1 {
		  font-size: inherit;
		  font-weight: inherit;
		  margin: inherit;
		}
        
        .error {
            color: #ff0000;
            font-style: italic;
            font-weight: bold;
        }
    </style>
    <meta name="viewport" content="initial-scale=1" />
  </head>
  <body layout="column" ng-controller="AppCtrl">

    <md-toolbar layout="row">
      <div class="md-toolbar-tools">
        <md-button ng-click="toggleSidenav('left')" hide-gt-sm class="md-icon-button">
          <md-icon aria-label="Menu" md-svg-icon="https://s3-us-west-2.amazonaws.com/s.cdpn.io/68133/menu.svg"></md-icon>
        </md-button>
        <h1>Hack and slash home</h1>
      </div>
    </md-toolbar>
    <div layout="row" flex>
        <md-sidenav layout="column" class="md-sidenav-left md-whiteframe-z2" md-component-id="left" md-is-locked-open="$mdMedia('gt-sm')">
          <md-button ng-click="register()">Register</md-button>
          <md-button ng-click="">Login</md-button>
          <md-button ng-click="">About us</md-button>
          <md-button ng-click="">Email support</md-button>
          <md-button ng-click="">Screens</md-button>
          <md-button ng-click="">About the Game</md-button>
          <md-button ng-click="user()">UserTest</md-button>
          <md-button ng-click="hero()">HeroTest</md-button>
        </md-sidenav>
        <ng-include ng-show="isRegister" src='"/hackandslash/register"'></ng-include>  <!--i intend to use something like this to cycle through pages-->
        <ng-include ng-show="isUser" src='"/hackandslash/user"'></ng-include>
        <ng-include ng-show="isHero" src='"/hackandslash/hero"'></ng-include>
    </div>
            <!--     Angular Material Dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<!--     this is from homeController.js it needs to be added so that the server will serve it via src="homeControlle.js"
                     it procs a http GET request              src="homeControlle.js" -->
        <script>    
        angular.module('StarterApp', ['ngMaterial']);

        angular.module('StarterApp').controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
                $scope.isRegister = false;
          $scope.toggleSidenav = function(menuId) {
            $mdSidenav(menuId).toggle();
          };
          
          $scope.hero = function(){
            $scope.isRegister = false;
            $scope.isUser = false;
            if(!$scope.isHero){
                $scope.isHero = true;   
            } else {
                $scope.isHero = false;
            }
            $mdSidenav('left').toggle();
          }
          
          $scope.user = function(){
            $scope.isRegister = false;
            $scope.isHero = false;
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
            if(!$scope.isRegister){
                $scope.isRegister = true;  
            } else {
                $scope.isRegister = false;
            }
            $mdSidenav('left').toggle();
          };
          // needs rebuilding to clear other bools then the one in parameter
          function clear(){
              $scope.isRegister = false;
              $scope.isUser = false;
              $scope.isHero = false;
          }

        }]);
        angular.module('StarterApp').controller('registerController', ['$scope', '$http', function($scope, $http){
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
    </script>
  </body>
</html>