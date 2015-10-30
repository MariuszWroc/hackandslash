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
        </md-sidenav>
        <div ng-show="isRegister" ng-controller="registerController" flex id="content">
        	<ng-include src="userRegistration.html"></ng-include>  <!--i intend to use something like this to cycle through pages-->
            <md-content layout="column" flex class="md-padding"> 
                firstname <input type="text" ng-model="user.firstname"/>
                lastname    <input type="text" ng-model="user.lastname"/>
                age         <input type="number" ng-model="user.age"/>
                login       <input type="text" ng-model="user.login"/>
                password    <input type="password" ng-model="user.password"/>
                <md-button ng-click="doRegister()">Register</md-button>
            </md-content>
        </div>
    </div>
<!--     Angular Material Dependencies -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
<!--     this is from homeController.js it needs to be added so that the server will serve it via src="homeControlle.js"
                     it procs a http GET request              src="homeControlle.js" -->
    <script>    
        var app = angular.module('StarterApp', ['ngMaterial']);

        app.controller('AppCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
                $scope.isRegister = false;
          $scope.toggleSidenav = function(menuId) {
            $mdSidenav(menuId).toggle();
          };

          $scope.register = function() {
            if(!$scope.isRegister){
                $scope.isRegister = true;   
            } else {
                $scope.isRegister = false;
            }
            $mdSidenav('left').toggle();
          };

        }]);
        app.controller('registerController', ['$scope', '$http', function($scope, $http){
                $scope.user ={
                            id : 0,
                            age : 26,
                            firstname : 'firstname',
                            lastname : 'lastname',
                            login : 'login',
                            password : 'password',
                            };
                $scope.doRegister = function (){
                    $http.get('/hackandslash/userList.json').success(function(res) {
                        console.log(res);
                        $scope.user.id = res.length;
                        console.log('adding',$scope.user);
//                        $http.post('/hackandslash/addUser', $scope.user).success(function() {
//                            console.log('success');
//                        }).error(function(error) {
//                            console.log(error);
//                        });
                    }).error(function(error) {
                        alert(error);
                    });
                    
                    
                };
        }]);
    </script>
  </body>
</html>