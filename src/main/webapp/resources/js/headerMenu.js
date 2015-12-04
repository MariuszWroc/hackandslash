'use strict';

/**
 * A simple directive used to adjust the class of header 
 * menu anchors based on their classes
 */
angular.module('AngularApp1')
  .directive('headerMenu', function () {
    
    return function(scope, element) {
      // Watch "activePage" variable created in MainCtrl 
      // controller's scope
      scope.$watch('activePage', function(value) {
        // On "activePage" variable change in scope 
        // - adjust currently active page anchor in 
        // the header
        var activeLink = element.find('.' + value),
            activeClass = 'active';
        // Strip all anchors elements from "active" class
        element.find('.' + activeClass)
                .removeClass(activeClass);
        activeLink.addClass(activeClass);
      });
    };
  });