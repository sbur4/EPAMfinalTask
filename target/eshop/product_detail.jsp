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
    <title>Admin page | eShop</title>
    <style>
        body {
            background-color: whitesmoke;
        }

        .container {
            margin-top: 150px;
        }
    </style>
</head>

<body class="w-100 h-auto p-0 m-0">

<%@ include file="header.jsp" %>

<div class="container bg-light">
    <div class="row flex-nowrap justify-content-center align-items-center m-1">
        <div class="col-2 m-1">
            <div class="m-1">
                <img class="w-50 mx-auto d-block" src="<c:out value="${product.getImage_url()}" />" alt="...">
            </div>
        </div>
        <div class="col-7 m-1">
            <div class="row m-2 fs-2 fw-bold text-uppercase"><c:out value="${product.getName()}"/></div>
            <div class="row m-2 fs-4">
<%--                <span><fmt:message key="label.descriptionProduct"/></span>--%>
                <span><c:out value="${product.getDescription()}"/></span>
            </div>
            <div class="row m-2 fs-4 text-danger">
<%--                <span><fmt:message key="label.price"/></span>--%>
                <span><c:out value="${product.getPrice()}"/> <pricetag:priceSign/></span>
            </div>
        </div>
        <div class="col-3 m-1 justify-content-between">
            <c:if test="${sessionScope.user.isAdmin() == true}">
                <form action="updateProduct" method="post">
                    <div class="row m-4">
                        <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>"/>
                        <button class="btn btn-secondary btn-lg" w-100><fmt:message key="button.updateProduct"/></button>
                    </div>
                </form>
                <form action="deleteProduct" method="post">
                    <div class="row m-4">
                        <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>"/>
                        <button class="btn btn-danger btn-lg w-100"><fmt:message key="button.deleteProduct"/></button>
                    </div>
                </form>
            </c:if>
            <c:if test="${sessionScope.user.isAdmin() == false}">
                <form action="addProductToCart" method="post">
                    <div class="row m-4">
                        <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>"/>
                        <button class="btn btn-danger btn-lg w-100"><fmt:message key="button.addToCart"/></button>
                    </div>
                </form>
            </c:if>
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
<%--<link rel="stylesheet" href="css/login.css">--%>

</html>



