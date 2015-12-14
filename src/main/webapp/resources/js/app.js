'use strict';

// Define an angular module for our app
var module = angular.module("StarterApp", ['ngRoute', 'ngMaterial']);
var prefix = '/hackandslash/';

module.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: '/hackandslash/register',
                    controller: 'menuController'
                }).
                when('/login', {
                    templateUrl: '/hackandslash/login',
                    controller: 'menuController'
                }).
                when('/about', {
                    templateUrl: '/hackandslash/about',
                    controller: 'menuController'
                }).
                when('/makers', {
                    templateUrl: '/hackandslash/makers',
                    controller: 'menuController'
                }).
                when('user/create', {
                    templateUrl: '/hackandslash/user/createHero',
                    controller: 'userController'
                }).
                when('/screens', {
                    templateUrl: '/hackandslash/screens',
                    controller: 'menuController'
                }).
                when('/contact',{
                    templateUrl: '/hackandslash/email',
                    controller: 'menuController'
                }).
                when('user/hero',{
                    templateUrl: '/hackandslash/user/hero',
                    controller: 'userController'
                }).
                when('/user/profil', {
                    templateUrl: '/hackandslash/user/profil',
                    controller: 'userController'
                }).
                when('/admin/menu', {
                    templateUrl: '/hackandslash/admin/panel',
                    controller: 'adminController'
                }).
                when('/',{
                   templateUrl: '/hackandslash/welcome',
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
