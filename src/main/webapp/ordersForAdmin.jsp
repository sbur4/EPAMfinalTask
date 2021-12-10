<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="eShop"/>
    <meta name="keywords" content="drinks, cola , fanta, sprite">
    <meta name="author" content="sburch">
    <title>Admin page | eShop </title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
</head>

<body>

<%@ include file="header.jsp" %>

<div class="container position-absolute start-50 top-30 translate-middle">
    <caption class="m-3">
        <h2><fmt:message key="label.orders.allOrders"/></h2>
    </caption>
    <table class="table table-success table-lg p-3">
        <thead class="table-secondary">
        <tr>
            <th scope="col"><fmt:message key="label.emailUser"/></th>
            <th scope="col"><fmt:message key="label.orders.orderedTime"/></th>
            <th scope="col"><fmt:message key="label.orders.orderStatus"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td class="thumbnail-img">
                    <a href="orderDetail?orderId=${order.get(0)}">
                            ${order.get(2)}
                    </a>
                </td>
                <td class="name-pr">
                    <a href="orderDetail?orderId=${order.get(0)}">
                            ${order.get(1)}
                    </a>
                </td>
                <td class="name-pr">
                    <a href="orderDetail?orderId=${order.get(0)}">
                            ${order.get(3)}
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
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
<link rel="stylesheet" href="css/allUsers.css">

</html>