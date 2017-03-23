<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 23.03.2017
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html"; charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Produkty</title>
</head>
<body>
    <section>
        <div class="jumbotron">
            <h1>Produkty</h1>
            <p>Dodaj produkt</p>
        </div>
    </section>
    <section class="container">
        <form:form modelAttribute="newProduct" class="form-horizontal">
            <fieldset>
                <legend>Dodaj nowy produkt</legend>
                <div class="form-group">
                    <label class="control-label col-lg-2 col-lg-2"
                           for="productId">Id produktu</label>
                    <div class="col-lg-10">
                        <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                        <form:input id="name" path="name" type="text" class="form:input-large"/>
                        <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                        <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                        <form:input id="category" path="category" type="text" class="form:input-large"/>
                        <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>
                        <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2" for="description">Opis</label>
                    <div class="col-lg-10">
                        <form:textarea id="description" path="description" rows="2"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-lg-2" for="discontinued">Wycofany</label>
                    <div class="col-lg-10">
                        <form:checkbox id="discontinued" path="discontinued" />
                    </div>
                </div>
                <div class="form-group">
                    <%--@declare id="condition"--%><label class="control-label col-lg-2" for="condition">Stan</label>
                    <div class="col-lg-10">
                        <form:radiobutton  path="condition" value="New"/> Nowy
                        <form:radiobutton  path="condition" value="Old"/> Używany
                        <form:radiobutton  path="condition" value="Refubrished"/> Odnowiony
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-lg-offset-2 col-lg-10">
                        <input type="submit" id="btnAdd" class="btn btn-primary" value="Dodaj">
                    </div>
                </div>

            </fieldset>
        </form:form>
    </section>
</body>
</html>
