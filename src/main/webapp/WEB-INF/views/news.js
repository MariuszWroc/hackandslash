
'use strict';

/**
 * News page controller
 */
angular.module('AngularApp1')
  .controller('NewsCtrl', ['$scope', function ($scope) {
    $scope.setActivePage('news');
  }]);