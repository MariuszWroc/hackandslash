'use strict';

// Define an angular module for our app
var module = angular.module("StarterApp", ['ngRoute', 'ngMaterial']);

module.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
                when('/register', {
                    templateUrl: '/hackandslash/register',
                    controller: 'registerController'
                }).
                when('/login', {
                    templateUrl: '/hackandslash/login',
                    controller: 'loginController'
                }).
                when('/hero', {
                    templateUrl: '/hackandslash/hero',
                    controller: 'heroController'
                }).
                when('about', {
                    templateUrl: '/hackandslash/about',
                    controller: 'menuController'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);
