<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>Login | eShop</title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
</head>
<body>

<div class="container d-flex w-100">
    <div class="row">
        <div>
            <h3 class="loginError"><c:out value="${error}"/></h3>
        </div>
        <div class="col">
            <h2 class="#"><fmt:message key="label.signin"/></h2>
            <form class="form needs-validation" novalidate method="post" action="login">
                <div class="mb-3">
                    <!-- <label for="inputEmail" class="sr-only">Email address</label> -->
                    <input type="email" class="form-control" placeholder="<fmt:message key="label.email"/> "
                           name="email" required autofocus>
                    <!-- <label for="inputPassword" class="sr-only">Password</label> -->
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control"
                           placeholder="<fmt:message key="label.password"/>"
                           name="password" required>
                </div>
                <div class="mb-3">
                    <button class="btn btn-outline-secondary w-100" type="submit" name="button"
                            value="Login">
                        <fmt:message key="button.login"/>
                    </button>
                </div>
                <div class="mb-3">
                    <a href="registration.jsp" class="btn btn-success w-100" role="button" name="button"
                       value="Register"><fmt:message key="button.register"/></a>
                </div>
            </form>
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
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/loginError.css">

</html>
