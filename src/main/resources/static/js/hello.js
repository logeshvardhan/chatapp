/*angular.module('hello', [])
  .controller('home', function($scope) {
    $scope.greeting = {id: 'xxx', content: 'Hello World!'}
})*/

/*(function(angular) {
	  angular.module("hello.controllers", []);
	  angular.module("hello.services", []);
	  var app = angular.module("hello", ["ngResource", "hello.controllers", "hello.services"]);
	}(angular));*/

var app =  angular.module('hello',[])
/*.controller('home', function($scope, Item) {
	Item.query(function(response) {
	      $scope.items = response ? response : [1,2,3];
	    });*/
app.controller('home', function($scope, $http) {
	  $http.get('/items/resource').success(function(data) {
	    $scope.greeting = data;
	  })
	});

app.controller('AppController', function($scope, Item) {
	
	 $scope.addItem = function(description) {
	      new Item({
	        description: description,
	        checked: false
	      }).$save(function(item) {
	        $scope.items.push(item);
	      });
	      $scope.newItem = "";
	    };
	});

app.$inject = ['$scope', 'Item'];
/*
.controller('AppController', function($scope, Item) {
    Item.query(function(response) {
	      $scope.items = response ? response : 10;
	    });
	});*/

/*
  .controller('home', function($scope, $http) {
  $http.get('/resource/').success(function(data) {
    $scope.greeting = data;
  })
});*/

var ItemFactory = function($resource) {
    return $resource('/items/:id', {
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
 
  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Item", ItemFactory);

