<%--
  Created by IntelliJ IDEA.
  User: Blazej
  Date: 30.03.2017
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <div class="container">
                <h1>Produkty</h1>
                <p>Dodaj produkt</p>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Zaloguj sie</h3>
                    </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/><br/>
                        </div>
                    </c:if>
                    <form action="<c:url value="/j_spring_security_check"></c:url> "method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nazwa użytkownika" name ='j_username'
                                       type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Haslo" name ='j_password'
                                       type="text" value="">
                            </div>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="zaloguj sie">
                        </fieldset>
                    </form>
                </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
