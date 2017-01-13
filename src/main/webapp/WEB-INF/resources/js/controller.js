/*
 * Using Angular JS framework to ensure product added to cart is displayed correctly
Javascript used to consume REST services
*/

var cartApp = angular.module("cartApp", [])

cartApp.controller("cartCtrl", function ($scope, $http) {
	
	//Goes to the HTTP.GET method in CartController.java to retrieve the cart JSON object
	//(which is passed into the response body)
	//If success, the cart JSON would be stored in data
	$scope.refreshCart = function (cartId) {
		$http.get('/EMusicStore/rest/cart/' + $scope.cartId).success(function (data) {
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function () { 
		$http['delete']('/EMusicStore/rest/cart/' + $scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	
	$scope.initCartId = function (cartId) {
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function (productId) {
		$http.put('/EMusicStore/rest/cart/add/' + productId).success(function (data) {
			$scope.refreshCart($http.get('/EMusicStore/rest/cart/get/cartId'));
			alert("Product successfully added to the cart.")
		});
	};;
	
	$scope.removeFromCart = function (productId) {
		$http.put('/EMusicStore/rest/cart/remove/' + productId).success(function (data) {
			$scope.refreshCart($http.get('/EMusicStore/rest/cart/get/cartId'));
		});
	}
	
})