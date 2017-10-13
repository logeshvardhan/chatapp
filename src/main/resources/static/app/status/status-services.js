/**
 * Author: Praveen
 */
(function(angular) {
  var StatusFactory = function($resource) {
	  //alert("inside remove.."+$resource);
    return $resource('/api/status/:id', {
      id: '@id'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  StatusFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("StatusService", StatusFactory);
}(angular));