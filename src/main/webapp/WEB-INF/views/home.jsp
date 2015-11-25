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
        </md-sidenav>
        <div ng-show="isRegister" ng-controller="registerController" flex id="content">
        	<ng-include src="userRegistration.html"></ng-include>  <!--i intend to use something like this to cycle through pages-->
            <md-content layout="column" flex class="md-padding">
                <form name="registration" ng-submit="doRegister()" novalidate> <!-- ng-submit="doRegister()"-->
                    <table>
	            	<tr>
	                    <td>
                                <label>Firstname:</label>
                            </td>
                            <td>
                                <input type="text" ng-model="user.firstname"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Lastname:</label>
                            </td>
                            <td>
                               <input type="text" ng-model="user.lastname"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Age:</label>
                            </td>
                            <td>
                                <input type="number" ng-model="user.age"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Gender:</label>
                            </td>
                            <td>
                                <md-input-container style="margin-right: 10px;">
                                    <md-select ng-model="user.gender">
                                        <md-option ng-repeat="gender in genders" value="{{gender.id}}">{{gender.name}}</md-option>
                                    </md-select>
                                </md-input-container>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Login:</label>
                            </td>
                            <td>
                                <input type="text" ng-model="user.login"/>
                                <label ng-show="errors.login" class="error">{{errors.login}}</label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>Password:</label>
                            </td>
                            <td>
                                <input type="password" ng-model="user.password"/>
                                <label ng-show="errors.password" class="error">{{errors.password}}</label>
                            </td>
                        </tr>
                    </table>
                    <md-button class="md-raised" type="submit">Register</md-button>
                    <md-button class="md-raised" type="button" ng-click="clear()">Clear</md-button>
                </form>
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