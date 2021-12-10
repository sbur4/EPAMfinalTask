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
    <title>Cart page | eShop</title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <style>
        body {
            background-color: whitesmoke;
        }

        .cnt {
            margin-top: 150px;
        }
    </style>
</head>

<body class="w-100 h-auto p-0 m-0">

<%@ include file="header.jsp" %>

<div class="container cnt">
    <div class="row my-3 w-100">
        <div class="col-6">
            <h2 class="fs-3"><fmt:message key="label.cart.productInMyCart"/></h2>
            <p><span class="fs-1"><fmt:message key="label.cart.sumOfProducts"/></span>
                <span class="text-danger fs-1 fw-bold"> <c:out value="${sumOfPrice}"/> <pricetag:priceSign/></span></p>
        </div>
        <div class="col-3">
            <c:if test="${sumOfPrice != 0}">
                <form action="order" method="post" style="text-align: center">
                    <button class="btn btn-success lg">
                        <fmt:message key="button.orderProducts"/>
                    </button>
                </form>
            </c:if>
        </div>
    </div>
</div>

<div class="container my-5 justify-content-center align-items-center align-content-center">
    <div class="row m-3">
        <caption class="m-3">
            <h2>
                <fmt:message key="label.orders.allOrders"/>
            </h2>
        </caption>
        <table class="table table">
            <thead class="table">
            <tr>
                <th scope="col">
                    <fmt:message key="label.imageProduct"/>
                </th>
                <th scope="col">
                    <fmt:message key="label.product"/>
                </th>
                <th scope="col">
                    <fmt:message key="label.descriptionProduct"/>
                </th>
                <th scope="col">
                    <fmt:message key="label.deleteOrder"/>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="product" items="${productIdsInCart}">
                <tr>
                    <td>
                        <div class="m-1"><img width="50" src="${product.getImage_url()}"/></div>

                    </td>
                    <td><a href="product?id=${product.getId() }">
                        <h4>${product.getName()}</h4>
                    </a></td>
                    <td>
                        <p>${product.getDescription()}</p>
                    </td>
                    <td>
                        <form action="deleteProductFromCart" method="post">
                            <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>">
                            <button class="btn btn-danger"><fmt:message
                                    key="button.deleteProductFromCart"/></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%--    <div class="row flex-nowrap justify-content-center align-items-center m-1">--%>
<%--        <c:forEach var="product" items="${productIdsInCart}">--%>
<%--            <div class="col-2 m-1">--%>
<%--                <div class="m-1">--%>
<%--                    <img class="w-50 mx-auto d-block" src="${product.getImage_url()}"/>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-3 m-1">--%>
<%--                <div class="m-1">--%>
<%--                    <a href="product?id=${product.getId() }">--%>
<%--                        <h4>${product.getName()}</h4>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col-3 m-1">--%>
<%--                <div class="m-1">--%>
<%--                    <form action="deleteProductFromCart" method="post">--%>
<%--                        <input type="hidden" name="productId" value="<c:out value="${product.getId()}"/>"/>--%>
<%--                        <button class="btn btn-danger"><fmt:message--%>
<%--                                key="button.deleteProductFromCart"/></button>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </c:forEach>--%>
<%--        <div class="col-4 m-1">--%>
<%--            <div class="row m-2 fs-4">--%>
<%--                <h2><fmt:message key="label.cart.productInMyCart"/></h2>--%>
<%--                <p><fmt:message key="label.cart.sumOfProducts"/> $<c:out value="${sumOfPrice}"/></p>--%>
<%--                <c:if test="${sumOfPrice != 0}">--%>
<%--                    <form action="order" method="post" style="text-align: center">--%>
<%--                        <button class="btn btn-success lg"><fmt:message key="button.orderProducts"/></button>--%>
<%--                    </form>--%>
<%--                </c:if>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

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