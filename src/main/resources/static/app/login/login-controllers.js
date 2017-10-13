/**
 * Author: Praveen
 */

(function(angular) {
  var LoginController = function($scope, LoginService) {
	  
	//Initialize Firebase
		/*const config = {
				
				apiKey: "AIzaSyCdoZWEvbkkq3N95LmV9gEJxdsywhBw6nM",
			    authDomain: "myf4h-c1b0a.firebaseapp.com",
			    databaseURL: "https://myf4h-c1b0a.firebaseio.com",
			    storageBucket: "myf4h-c1b0a.appspot.com",
			    messagingSenderId: "831041923537"
				
				
				apiKey: "AIzaSyAJv4gdGGSCrNibza9ZT3wnhG_J6F0izoU",
			    authDomain: "like2eat-auth-cc883.firebaseapp.com",
			    databaseURL: "https://like2eat-auth-cc883.firebaseio.com",
			    storageBucket: "like2eat-auth-cc883.appspot.com",
			    messagingSenderId: "358647345474"
		};
		firebase.initializeApp(config);
	  
	// Get elements
		
		const txtEmail = document.getElementById('txtEmail');
		const txtPasswd = document.getElementById('txtPasswd');
		const btnLogin = document.getElementById('btnLogin');
		const btnSignUp = document.getElementById('btnSignUp');
		const btnLogout = document.getElementById('btnLogout');
		const msgDiv = document.getElementById('msgDiv');
		
		// Add login
		
		btnLogin.addEventListener('click', e => {
			const email = txtEmail.value;
			const passwd = txtPasswd.value;
			const auth = firebase.auth();
			
			$scope.userLoginAuth = function(){
				LoginService.query(function(response) {
					
				});
				      
			};
			
			const promise = auth.signInWithEmailAndPassword(email, passwd);
			promise.then(firebaseUser => {
				firebaseUser.getToken(true).then(token => {
					alert("token..."+token);
					$.ajax({
						type: 'POST',
						url: '/login/firebase/user',
						data: {token: token},
						success: function (result) {
							$('#msgDiv').text(JSON.stringify(result));
							console.log("RESULT: " + result);
						}
					});
				}).catch(e => alert(e.message));
			}).catch(e => alert(e.message));
		});
		
		// Add sign-up
		btnSignUp.addEventListener('click', e => {
			const email = txtEmail.value;
			const passwd = txtPasswd.value;
			const auth = firebase.auth();
			
			const promise = auth.createUserWithEmailAndPassword(email, passwd);
			promise.catch(e => alert(e.message));		
		});
		
		// Add logout
		btnLogout.addEventListener('click', e => {
			firebase.auth().signOut();
			$.ajax({
				url: '/logout',
				success: function (result) {
					$('#msgDiv').text(JSON.stringify(result));
					console.log("Logout: " + result);
				}
			});
		});
		
		// Add auth listener
		firebase.auth().onAuthStateChanged(firebaseUser => {
			if (firebaseUser) {
				console.log(firebaseUser);
			} else {
				console.log("Not logged in...");
			}
		});*/
	
  };
  
  LoginController.$inject = ['$scope','LoginService'];
  angular.module("myApp.controllers").controller("LoginController", LoginController);
}(angular));

