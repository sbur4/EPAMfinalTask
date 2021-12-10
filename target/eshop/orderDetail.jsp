<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="pricetag" uri="/WEB-INF/tld/price.tld" %>
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
    <title>Admin page | eShop</title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <style>
        .container {
            margin-top: 150px;
        }
    </style>
</head>

<body class="w-100 p-0 m-0">

<%@ include file="header.jsp" %>

<div class="container bg-light">
    <div class="row flex-nowrap justify-content-center align-items-center m-1">
        <c:forEach var="product" items="${products }">
            <div class="col-2 m-1">
                <div class="m-1">
                    <a href="product?id=${product.getId() }">
                        <img class="w-50 mx-auto d-block" src="${product.getImage_url()}" alt="#"/>
                    </a>
                </div>
            </div>
            <div class="col-7 m-1">
                <div class="row m-2 fs-2 fw-bold text-uppercase"><a class="link-dark" href="product?id=${product.getId() }">
                        ${product.getName()}
                </a></div>
                <div class="row m-2 fs-4 text-danger">
                    <span>${product.getPrice()} <pricetag:priceSign/></span>
                </div>
            </div>
        </c:forEach>
        <div class="col-3 m-1 justify-content-between">
            <c:if test="${sessionScope.user.isAdmin() == true}">
                <div class="row m-4">
                    <form action="changeStatus" method="post">
                        <div class="m-1 w-100">
                            <select name="statusId" class="m-1 w-100">
                                <c:forEach var="status" items="${statuses }">
                                    <option value="<c:out value="${status.getId()}"/>"/>
                                    <c:out value="${status.getStatusName()}"/></option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="<fmt:message key="label.changeStatus"/>" class="btn btn-success m-1 w-100">
                        </div>
                        <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>"/>
                    </form>
                    <div class="m-1 w-100">
                        <form action="DeleteOrderAdminService" method="post">
                            <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>"/>
                            <button class="btn btn-danger btn m-1 w-100"><fmt:message key="label.deleteOrder"/></button>
                        </form>
                    </div>
                </div>
            </c:if>
            <c:if test="${sessionScope.user.isAdmin() == false}">
                <div class="row m-4">
                    <c:if test="${currentStatus.getId()==5 or currentStatus.getId()==1 or currentStatus.getId()==4}">
                        <form action="changeStatus" method="post">
                            <input type="hidden" name="statusId" value="2"/>
                            <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>"/>
                            <button class="btn btn-danger btn m-1 w-100"><fmt:message key="label.cancelOrder"/></button>
                        </form>
                    </c:if>
                    <c:if test="${currentStatus.getId()== 4}">
                        <form action="changeStatus" method="post">
                            <input type="hidden" name="statusId" value="3"/>
                            <input type="hidden" name="orderId" value="<c:out value="${orderId}"/>"/>
                            <button class="btn btn-info btn m-1 w-100"><fmt:message key="label.orderArrived"/></button>
                        </form>
                    </c:if>
                </div>
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