<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="pricetag" uri="/WEB-INF/tld/price.tld" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="error page eShop"/>
    <meta name="keywords" content="error page">
    <meta name="author" content="sburch">
    <title>Delivery page | eShop</title>
    <style>
        body {
            font-family: 'Roboto', sans-serif;
        }

        .container {
            margin-top: 200px;
        }
    </style>
</head>

<body class="w-100 h-0 m-0 p-0">

<%@ include file="header.jsp" %>

<div class="container">
    <div class="row justify-content-center align-content-md-center w-100">
        <div class="col-sm-6 col-lg-6 mb-3">
            <div class="checkout-address">
                <div class="title-left">
                    <h3><fmt:message key="label.billingAdress"/></h3>
                </div>
                <form class="form-signin" method="post" action="createOrder">
                    <div class="mb-3">
                        <label for="country"><fmt:message key="label.country"/></label>
                        <input type="text" class="form-control" id="country" placeholder="" name="country">
                    </div>
                    <div class="mb-3">
                        <label for="city"><fmt:message key="label.city"/></label>
                        <input type="text" class="form-control" id="city" placeholder="" name="city">
                    </div>
                    <div class="mb-3">
                        <label for="street"><fmt:message key="label.street"/></label>
                        <input type="text" class="form-control" id="street" placeholder="" required
                               name="street">
                    </div>
                    <div class="mb-3">
                        <label for="phone"><fmt:message key="label.phoneNumber"/></label>
                        <input type="text" class="form-control" id="phone" placeholder="" name="phone">
                    </div>
                    <button name="button" value="sumbit" class="btn btn-outline-success my-2 my-sm-0"
                            type="submit"><fmt:message key="label.placeOrder"/>
                    </button>
                </form>
            </div>
        </div>
        <div class="col-sm-6 col-lg-6 mb-3">
            <div class="row">
                <div class="col-md-12 col-lg-12">
                    <div class="order-box">
                        <div class="title-left">
                            <h3><fmt:message key="label.yourOrder"/></h3>
                        </div>
                        <div class="d-flex gr-total m-2">
                            <span class="text-danger fs-1 fw-bold"><fmt:message key="label.totalPrice"/>: ${totalPrice} <pricetag:priceSign/></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!-- bootstrap 5 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- fontawesome 6 -->
<script src="https://kit.fontawesome.com/72eaa8a44c.js" crossorigin="anonymous"></script>
<!-- googlefonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
        href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
        rel="stylesheet">
<!-- jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- css -->
<link rel="stylesheet" href="css/registration.css">

</html>