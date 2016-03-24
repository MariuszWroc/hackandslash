'use strict';

// Define an angular module for our app
var module = angular.module("StarterApp", ['ngRoute', 'ngMaterial']);
var prefix = '/hackandslash';

module.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: prefix + '/register',
                    controller: 'registerController'
                }).
                when('/login', {
                    templateUrl: prefix + '/login',
                    controller: 'menuController'
                }).
                when('/logout', {
                    templateUrl: prefix + '/logout',
                    controller: 'menuController'
                }).
                when('/logout/success', {
                    templateUrl: prefix + '/logout/success',
                    controller: 'menuController'
                }).
                when('/about', {
                    templateUrl: prefix + '/about',
                    controller: 'menuController'
                }).
                when('/authors', {
                    templateUrl: prefix + '/authors',
                    controller: 'menuController'
                }).
                when('/screens', {
                    templateUrl: prefix + '/screens',
                    controller: 'menuController'
                }).
                when('/contact', {
                    templateUrl: prefix + '/email',
                    controller: 'menuController'
                }).
                when('/user/hero', {
                    templateUrl: prefix + '/user/hero',
                    controller: 'heroController'
                }).
                when('/user/game', {
                    templateUrl: prefix + '/user/game',
                    controller: 'gameController'
                }).
                when('/denied', {
                    templateUrl: prefix + '/denied',
                    controller: 'menuController'
                }).
                when('/user/profil', {
                    templateUrl: prefix + '/user/profil',
                    controller: 'userController'
                }).
                when('/admin/menu', {
                    templateUrl: prefix + '/admin/panel',
                    controller: 'adminController'
                }).
                when('/user/journal', {
                    templateUrl: prefix + '/user/journal',
                    controller: 'gameController'
                }).
                when('/user/combat', {
                    templateUrl: prefix + '/user/combat',
                    controller: 'gameController'
                }).
                when('/user/shop', {
                    templateUrl: prefix + '/user/shop',
                    controller: 'gameController'
                }).
                when('/user/equipment', {
                    templateUrl: prefix + '/user/equipment',
                    controller: 'gameController'
                }).                         
                when('/', {
                   templateUrl: prefix + '/welcome',
                   controller: 'menuController'
                }).
                when('/failed', {
                    templateUrl: prefix + '/failed',
                    controller: 'menuController'
                 }).
                otherwise({
                    redirectTo: '/'
                });

    }]);


module.controller('AppCtrl', function($scope, $mdDialog, $mdMedia, $mdSidenav) {
	$scope.status = '';
	$scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm')

				$scope.toggleSidenav = function() {
				$mdSidenav('left').toggle();
			};
	
			var locals = {'fromUserProfile':false};
        $scope.logout = function(ev) {
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
        };
        
        $scope.login = function(ev) {
            $mdDialog.show({
	    	templateUrl: prefix + '/login',
	        parent: angular.element(document.querySelector('#container')),
	        targetEvent: ev,
	        locals: locals,
	        plain: true,
                controller: 'DialogController',
            // perform delete operation
            }, function (value) {
                //Do something 
            });
        }
});