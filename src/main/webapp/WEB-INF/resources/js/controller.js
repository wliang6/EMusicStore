/*
 * Using Angular JS framework to ensure product added to cart is displayed correctly
Javascript used to consume REST services
*/

var cartApp = angular.module("cartApp", [])

cartApp.config(function ($httpProvider){
	$httpProvider.defaults.headers.post['X-CSRFToken'] = $('input[name=csrfmiddlewaretoken]').val();
})

cartApp.controller("cartCtrl", function ($scope, $http) {
	
	//Goes to the HTTP.GET method in CartController.java to retrieve the cart JSON object
	//(which is passed into the response body)
	//If success, the cart JSON would be stored in data
	$scope.refreshCart = function (cartID) {
		$http.get('/EMusicStore/rest/cart/' + $scope.cartID).success(function (data) {
			$scope.cart = data;
		});
	};
	
	$scope.clearCart = function () { 
		$http['delete']('/EMusicStore/rest/cart/' + $scope.cartID).success($scope.refreshCart($scope.cartID));
	};
	
	$scope.initCartId = function (cartID) {
		$scope.cartID = cartID;
		$scope.refreshCart(cartID);
	};
	
	$scope.addToCart = function (productID, header, token) {
		$http.put('/EMusicStore/rest/cart/add/' + productID, {csrf_token: token}).success(function (data) {
			$scope.refreshCart($http.get('/EMusicStore/rest/cart/cartID'));
			alert("Product successfully added to the cart.")
		});
	};;
	
	$scope.removeFromCart = function (productID) {
		$http.put('/EMusicStore/rest/cart/remove/' + productID).success(function (data) {
			$scope.refreshCart($http.get('/EMusicStore/rest/cart/cartID'));
		});
	}
	
})