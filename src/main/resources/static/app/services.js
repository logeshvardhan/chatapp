/**
 * Author: Praveen
 */
(function(angular) {
  var ItemFactory = function($resource) {
	  //alert("inside remove.."+$resource);
    return $resource('/items/:id', {
      id: '@itemId'
    }, {
      update: {
        method: "PUT"
      },
      remove: {
        method: "DELETE"
      }
    });
  };
  
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);
}(angular));