'use strict';

var App = angular.module('PetStore_App', []).config(
		[ '$routeProvider', function($routeProvider) {
			$routeProvider.when('/adminLoginPage', {
			templateUrl : 'views/login_register.htm',
			controller : productController
				
			}).when('/adminmain', {
				templateUrl : 'views/adminmain.htm',
				controller : productController
				
			}).when('/categoryDetails', {
				templateUrl : 'views/categoryDetails.htm',
				controller : productController
				
			}).when('/productDetails', {
				templateUrl : 'views/productDetails.htm',
				controller : productController
					
			}).when('/viewProductDetails', {
				templateUrl : 'views/viewProductDetails.htm',
				controller : productController
					
			}).when('/place_order', {
				templateUrl : 'views/orderDetails.htm',
				controller : productController
					
			}).when('/item_ordered', {
				templateUrl : 'views/success.htm',
				controller : productController
					
			}).when('/cart', {
				templateUrl : 'views/shopping_cart.htm',
				controller : productController
		
			}).otherwise({
				redirectTo : '/adminLoginPage'
			});
		} ]);

App.factory("DataService", [ '$http', function($http) {

	var myStore = new store($http);

	var myCart = new shoppingCart("PetStore_App");

	return {
		store : myStore,
		cart : myCart
	};
} ]);