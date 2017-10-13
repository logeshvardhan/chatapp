/**
 * 
 * Author: Praveen Kumar B
 */

(function(angular) {
   'use strict';	
	angular.module("myApp").config(function($stateProvider, $urlRouterProvider) {
	    
	    
	    $stateProvider	    
	    
    	
    	.state('status', {
    		parent: 'home_template',	    	
	    	url: '/status',
	     	views: {
	     		'' : {
					templateUrl : 'index.html'
				},                
                    'content_view' : { 
	                templateUrl: 'app/status/status.html',
	                controller: 'StatusController',
	            }
	        }
      	
    	})
    	
    	
	    
	   	});
  
}(angular));