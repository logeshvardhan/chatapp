/**
 * Author: Praveen
 */
(function(angular) {
  var LoginFactory = function($resource) {
	  //alert("inside remove.."+$resource);
    return $resource('/login/firebase/user', {
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
  
  LoginFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("LoginService", LoginFactory);
}(angular));