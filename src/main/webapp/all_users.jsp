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
    <meta name="description" content="eShop"/>
    <meta name="keywords" content="drinks, cola , fanta, sprite">
    <meta name="author" content="sburch">
    <title>Admin page | eShop </title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
</head>

<body>

<%@ include file="header.jsp" %>

<div class="container my-5">
    <caption class="m-3">
        <h2><fmt:message key="label.users"/></h2>
    </caption>
    <table class="table table-success table-lg p-3">
        <thead class="table-secondary">
        <tr>
            <th scope="col"><fmt:message key="label.firstName"/></th>
            <th scope="col"><fmt:message key="label.lastName"/></th>
            <th scope="col"><fmt:message key="label.emailUser"/></th>
            <th scope="col"><fmt:message key="label.userActivity"/></th>
        </tr>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.getFirstName()}</td>
                <td>${user.getLastName()}</td>
                <td>${user.getEmail()}</td>
                <c:if test="${user.isActive() == true}">
                    <form action="deactivateUser" method="post">
                        <input type="hidden" name="userId" value="<c:out value="${user.getId()}"/>"/>
                        <td scope="col">
                            <button class="btn btn-danger"><fmt:message key="label.deactiveUser"/></button>
                        </td>
                    </form>
                </c:if>
                <c:if test="${user.isActive() == false}">
                    <form action="activateUser" method="post">
                        <input type="hidden" name="userId" value="<c:out value="${user.getId()}"/>"/>
                        <td scope="col">
                            <button class="btn btn-success"><fmt:message key="label.activeUser"/></button>
                        </td>
                    </form>
                </c:if>
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