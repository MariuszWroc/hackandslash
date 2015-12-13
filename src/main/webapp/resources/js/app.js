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
                when('/about', {
                    templateUrl: '/hackandslash/about',
                }).
                when('/makers', {
                    templateUrl: '/hackandslash/makers',
                }).
                when('user/create', {
                    templateUrl: '/hackandslash/createHero',
                    controller: 'userController'
                }).
                when('/screens', {
                    templateUrl: '/hackandslash/screens',
                }).
                when('/contact',{
                    templateUrl: '/hackandslash/email',
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
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);
