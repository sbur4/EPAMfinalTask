<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pricetag" uri="/WEB-INF/tld/price.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=chrome">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="drinks online shop"/>
    <meta name="keywords" content="drink, cola, sprite, fanta, water">
    <meta name="author" content="sburch">
    <title>New user | eShop</title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>

</head>

<body class="w-100 h-auto p-0 m-0">

<div class="container d-flex mt-5 justify-content-center w-100">
    <h2 class="loginError"><c:out value="${error}"/></h2>
    <div class="row">
        <div class="col">
            <form class="form-signin" method="post" action="registration">
                <h3 class="form-signin-heading justify-content-center"><fmt:message key="label.registration"/></h3>
                <input type="email" class="form-control my-2" placeholder="<fmt:message key="label.email"/>"
                       name="email" required
                       autofocus>
                <input name="firstName" id="FirstName" class="form-control my-2"
                       placeholder="<fmt:message key="label.firstName"/>"
                       required autofocus>
                <input name="lastName" id="LastName" class="form-control my-2"
                       placeholder="<fmt:message key="label.lastName"/>" required
                       autofocus>
                <input name="password" type="password" id="inputPassword" class="form-control my-2"
                       placeholder="<fmt:message key="label.password"/>" required>
                <div class="my-2">
                    <button name="button" value="Register" class="btn btn-primary w-100"
                            type="submit"><fmt:message key="button.register"/></button>
                </div>
            </form>
            <div class="my-2">
                <a href="login" class="btn btn-success w-100" role="button" name="button" value="Register"><fmt:message
                        key="button.login"/></a>
            </div>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>

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
<%--<link rel="stylesheet" href="css/registration.css">--%>

</html>
