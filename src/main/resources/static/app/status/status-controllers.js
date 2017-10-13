/**
 * Author: Praveen
 */

(function(angular) {
  var StatusController = function($scope, StatusService) {
	//alert("Insider app controller ui");
	  StatusService.query(function(response) {
      $scope.statuses = response ? response : [];
    });
    
    $scope.addItem = function(data) {
     //alert("Inside add item..");
      new StatusService({ 
    	  status: $scope.status,
        createdDate: new Date()
      }).$save(function(status) {
        $scope.statuses.push(status);
      });
      $scope.status = "";
    };
    
    $scope.updateStatus = function(status) {
    	status.$update();
    };
    
    $scope.deleteItem = function(status) {
    	status.$remove(function() {
        $scope.statuses.splice($scope.statuses.indexOf(status), 1);
      });
    };
  };
  
  StatusController.$inject = ['$scope', 'StatusService'];
  angular.module("myApp.controllers").controller("StatusController", StatusController);
}(angular));

