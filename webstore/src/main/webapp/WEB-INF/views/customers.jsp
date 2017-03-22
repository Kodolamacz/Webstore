<%@page pageEncoding="UTF-8" contentType="text/html; cahrset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstra.min.css">
	<title>Klienci</title>
	</head>
	<body>
		<section>
			<div class="jumbotron">
				<div class=container>
					<h1>Klienci</h1>
					<p>Wszyscy klienci naszego sklepu</p>
				</div>
			</div>
		</section>
		<section class="container">
			<div class="row">
			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-6 col-md-3" style="padding-bottom; 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${customer.customerId}</h3>
							<p>${customer.name } </p>
							<p>${customer.address}</p> 
							<p>Liczba dokonanych transakcji: ${customer.noOfOrdersMade} </p>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</section>
	</body>
</html>