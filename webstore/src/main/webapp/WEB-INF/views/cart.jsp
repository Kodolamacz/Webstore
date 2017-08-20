<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 28.05.2017
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/webstore/resource/js/controllers.js"></script>
    <title>Koszyk</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Koszyk</h1>
                <p> Produkty w Twoim koszyku </p>
            </div>
        </div>
    </section>
    <section class="container" data-ng-app="cartApp">
        <div data-ng-controller="cartCtrl" data-ng-init="initCartId('${cartId}')">
            <div>
                <a class="btn btn-danger pull-left" data-ng-click="clearCart()">
                    <span class="glyphicon-remove-sign"></span> Wyczysc koszyk
                </a>
                <a href="#" class="btn btn-success pull-right">
                    <span class="glyphicon-shopping-cart glyphicon"></span>
                    Kupuję
                </a>
            </div>
            <table class="table table-hover">
                <tr>
                    <th> Produkt </th>
                    <th> Cena za sztuke </th>
                    <th> Liczba sztuk </th>
                    <th> Cena </th>
                    <th> Akcja </th>
                </tr>
                <tr data-ng-repeat="item in cart.cartItems">
                    <td>{{item.product.productId}}-{{item.product.name}}</td>
                    <td>{{item.product.unitPrice}}</td>
                    <td>{{item.quantity}}</td>
                    <td>{{item.totalPrice}}</td>
                    <td>
                        <a href="#" class="label label-danger" data-ng-click=
                                "removeFromCart(item.product.productId)">
                            <span class="glyphicon glyphicon-remove"></span> Usun
                        </a>
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                    <th>Łączna cena</th>
                    <th>{{cart.grandTotal}}</th>
                    <th></th>
                </tr>
            </table>
            <a href="<spring:url value="/products" /> " class="btn btn-default">
                <span class="glyphicon-hand-left glyphicon"></span> Wróć do zakupów
            </a>

        </div>
    </section>
</body>
</html>
