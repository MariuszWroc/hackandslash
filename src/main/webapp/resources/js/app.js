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
                when('/about', {
                    templateUrl: '/hackandslash/about',
                    controller: 'menuController'
                }).
                when('/makers', {
                    templateUrl: '/hackandslash/makers',
                    controller: 'menuController'
                }).
                when('/create', {
                    templateUrl: '/hackandslash/createHero',
                    controller: 'heroController'
                }).
                when('/screens', {
                    templateUrl: '/hackandslash/screens',
                    controller: 'menuController'
                }).
                when('/contact',{
                    templateUrl: '/hackandslash/email',
                    controller: 'menuController'   
                }).
                when('/hero',{
                    templateUrl: '/hackandslash/user/hero',
                    controller: 'menuController'   
                }).
                when('/user/profil', {
                    templateUrl: '/hackandslash/user/profil',
                    controller: 'userController'
                }).
                when('/admin/menu', {
                    templateUrl: '/hackandslash/admin/panel',
                    controller: 'adminController'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }]);
