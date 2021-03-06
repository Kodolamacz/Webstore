/**
 * Created by Blazej on 28.05.2017.
 */
var cartApp = angular.module('cartApp',[]);
cartApp.controller('cartCtrl',function ($scope,$http) {

    $scope.refreshCart = function (cartId) {

        $http.get('/rest/cart/'+$scope.cartId)
            .success(function (data) {
            $scope.cart = data;
        });

    };
    $scope.clearCart = function () {
        $http.delete('/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
    };

    $scope.initCart = function (cartId) {
      $scope.cartId = cartId;
      $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function (productId) {
        $http.put('/rest/cart/add/' + productId).success(function (data) {
           $scope.refreshCart($http.get('/rest/cart/get/cartId'));
           alert("Produkt dodany do koszyka");
        });
    };
    $scope.removeFromCart = function (productId) {
      $http.put('rest/cart/remove/'+productId).success(function (data) {
          $scope.refreshCart($http.get('/rest/cart/get/cartId'));
      });
    };
});