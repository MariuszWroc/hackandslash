'use strict';

/**
 * Main application controller attached to "body" element
 */
angular.module('AngularApp1')
  .controller('MainCtrl', ['$scope', function ($scope) {
    // setActivePage will be available to all children 
    // scopes of this controller
    $scope.setActivePage = function(name) {
      $scope.activePage = name;
    };
  }]);