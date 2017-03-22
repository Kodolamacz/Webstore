
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstra.min.css">
<title>Szczegóły produktu</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class ="container">
				<h1> Produkt</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description} </p>
				<p> 
					<strong> Kod produktu: </strong><span class="label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>Producent: </strong> ${product.manufacturer}
				</p>
				<p>
					<strong>Kategoria: </strong> ${product.category}
				</p>
				<p>
					<strong>Liczba dostępnych sztuk: </strong> ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice} PLN</h4>
				<p>
					<a href=" <spring:url value="/products" />" class="btn btn-btndefault">
					<span class="gylphicon-hand-left gylphicon"></span> Wstecz </a>
					<a href="#" class="btn btn-warning btn-large">
					<span class="gylphicon-shopping-cart gylphicon"></span>
					Zamów teraz
					</a>
				
			</div>
		</div>
</body>
</html>