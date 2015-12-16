'use strict';

// Define an angular module for our app
var module = angular.module("StarterApp", ['ngRoute', 'ngMaterial']);
var prefix = '/hackandslash';

module.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: prefix + '/register',
                    controller: 'menuController'
                }).
                when('/login', {
                    templateUrl: prefix + '/login',
                    controller: 'menuController'
                }).
                when('/about', {
                    templateUrl: prefix + '/about',
                    controller: 'menuController'
                }).
                when('/makers', {
                    templateUrl: prefix + '/makers',
                    controller: 'menuController'
                }).
                when('/user/create', {
                    templateUrl: prefix + '/user/createHero',
                    controller: 'menuController'
                }).
                when('/screens', {
                    templateUrl: prefix + '/screens',
                    controller: 'menuController'
                }).
                when('/contact',{
                    templateUrl: prefix + '/email',
                    controller: 'menuController'
                }).
                when('/user/hero',{
                    templateUrl: prefix + '/user/hero',
                    controller: 'heroController'
                }).
                when('/user/profil', {
                    templateUrl: prefix + '/user/profil',
                    controller: 'userController'
                }).
                when('/admin/menu', {
                    templateUrl: prefix + '/admin/panel',
                    controller: 'adminController'
                }).
                when('/',{
                   templateUrl: prefix + '/welcome',
                   controller: 'menuController'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);

module.controller('AppCtrl', [ '$scope', '$mdSidenav', function($scope, $mdSidenav) {
			$scope.toggleSidenav = function() {
				$mdSidenav('left').toggle();
			};
		} ]);
