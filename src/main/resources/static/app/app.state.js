/**
 * 
 * Author: Praveen Kumar B
 */

(function(angular) {
   'use strict';	
	angular.module("myApp").config(function($stateProvider, $urlRouterProvider) {
	    
	    $urlRouterProvider.otherwise('/home');
	    // alert("inside app config...");
	    $stateProvider
	    
	    .state('home_template', {
	    	abstract: true,
            templateUrl: 'app/mainhome.html'
        })
	
	    .state('home', {
	    	parent: 'home_template',
	    	url: '/home',
	     	views: {                
                    
				    '': {              	
			      	  templateUrl: 'app/mainhome.html'
				    },			      	 
			      'header_view' : { 
			          templateUrl: 'app/home/header_prelogin.html'
			      },
			      'content_view' : { 
			    	  templateUrl: 'app/home/home.html'
			      },
			      'footer_view' : { 
			          templateUrl: 'app/home/mainfooter.html'
			      }
	    		
	    
	        }
      	
    	})    	
    	
    	.state('external', {
	    	external: true
    	})
	    
	   	});
  
}(angular));