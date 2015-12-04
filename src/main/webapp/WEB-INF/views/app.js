'use strict';

angular.module('AngularApp1', [])
  .config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/news', {
        templateUrl: 'views/news.html',
        controller: 'NewsCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/news'
      });
  }]);