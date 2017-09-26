app=angular
.module('myApp', []);
    


app.controller('UsersController', function ($scope,$location, $log,$http) {
 
    $scope.signUpfunction = function (){
    	var obj=$scope.signUp;
    	$http.post("http://localhost:8080/spring-mvcApp/customer/signup",obj).then(function(d){
    		 alert("Welcome  Successfully signup Thank you ! ")
    		$location.path("/success.html");
			},function(error){
				 alert(" Sorry Try again ")
				console.log("Error getting products ",error);
			})
    }
   
   $scope.signInfunction = function (){
	var signInUrl = 'http://localhost:8080/spring-mvcApp/customer/login?email='+$scope.signIn.email +'&password='+$scope.signIn.password;
   	$http.post(signInUrl).then(function(d){
   		$location.path("/Welcome.html");
			},function(error){
				 alert(" Sorry Try again ")
				console.log("Error getting products ",error);
			})
   }
   $scope.resetPassword = function (){
		var resetUrl = 'http://localhost:8080/spring-mvcApp/customer/forgotpass?email='+$scope.signIn.email +'&password='+$scope.signIn.password;
	       
	   	$http.post(resetUrl).then(function(d){
	           alert(" Your password is reset successfully ")
	           $location.path("/success.html");
				},function(error){
					 alert(" Sorry Try again ")
					console.log("Error getting products ",error);
				})
	   }
});