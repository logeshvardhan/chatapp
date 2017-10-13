/**
 * Author: Praveen
 */

(function(angular) {
  var AppController = function($scope, Item) {
	//alert("Insider app controller ui");
    Item.query(function(response) {
      $scope.items = response ? response : [];
    });
    
    $scope.addItem = function(data) {
     //alert("Inside add item..");
      new Item({
        description: data.Desc,
        checked: data.checked,
        createdDate: data.creDate
      }).$save(function(item) {
        $scope.items.push(item);
      });
      $scope.newItem = "";
    };
    
    $scope.updateItem = function(item) {
      item.$update();
    };
    
    $scope.deleteItem = function(item) {
    	item.$remove(function() {
        $scope.items.splice($scope.items.indexOf(item), 1);
      });
    };
  };
  
  AppController.$inject = ['$scope', 'Item'];
  angular.module("myApp.controllers").controller("AppController", AppController);
}(angular));

