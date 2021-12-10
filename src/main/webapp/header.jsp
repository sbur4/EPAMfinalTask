<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.List" %>

<header>
    <nav class="nav navbar-expand-sm navbar-light fixed-top">
        <div class="container-fluid">
            <ul class="navbar-nav d-flex justify-content-center align-items-center">
<%--                page=${page}&pageSize=${pageSize}&sortBy--%>
                <li class="nav-item m-1 align-content-center"><a href="home" class="btn" role="button"><img class="m-0 p-0" src="assets\logo_white-blue.svg" style="width: 70px"></a></li>
                <%--                    <li class="nav-item px-3">--%>
                <%--                        <a class="nav-link text-white" href="#">--%>
                <%--                            <svg xmlns="http://www.w3.org/2000/svg" width="25"--%>
                <%--                                 height="25" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">--%>
                <%--                                <path--%>
                <%--                                        d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>--%>
                <%--                            </svg>--%>
                <%--                        </a>--%>
                <%--                    </li>--%>
                <%--                    <li class="nav-item px-3">--%>
                <%--                        <button type="button" class="btn text-white" data-bs-toggle="modal"--%>
                <%--                                data-bs-target="#myModal">--%>
                <%--                            <svg xmlns="http://www.w3.org/2000/svg" height="27"--%>
                <%--                                 viewBox="0 0 25 25" width="27" fill="currentColor">--%>
                <%--                                <path d="M0 0h24v24H0V0z" fill="none"/>--%>
                <%--                                <path--%>
                <%--                                        d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zM7.07 18.28c.43-.9 3.05-1.78 4.93-1.78s4.51.88 4.93 1.78C15.57 19.36 13.86 20 12 20s-3.57-.64-4.93-1.72zm11.29-1.45c-1.43-1.74-4.9-2.33-6.36-2.33s-4.93.59-6.36 2.33C4.62 15.49 4 13.82 4 12c0-4.41 3.59-8 8-8s8 3.59 8 8c0 1.82-.62 3.49-1.64 4.83zM12 6c-1.94 0-3.5 1.56-3.5 3.5S10.06 13 12 13s3.5-1.56 3.5-3.5S13.94 6 12 6zm0 5c-.83 0-1.5-.67-1.5-1.5S11.17 8 12 8s1.5.67 1.5 1.5S12.83 11 12 11z"/>--%>
                <%--                            </svg>--%>
                <%--                        </button>--%>
                <%--                    </li>--%>
                <%--                    <li class="nav-item dropdown float-end">--%>
                <%--                        <a class="nav-link dropdown-toggle text-white" href="#" role="button"--%>
                <%--                           data-bs-toggle="dropdown">--%>
                <%--                            <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"--%>
                <%--                                 fill="currentColor" class="bi bi-translate" viewBox="0 0 16 16">--%>
                <%--                                <path--%>
                <%--                                        d="M4.545 6.714 4.11 8H3l1.862-5h1.284L8 8H6.833l-.435-1.286H4.545zm1.634-.736L5.5 3.956h-.049l-.679 2.022H6.18z"/>--%>
                <%--                                <path--%>
                <%--                                        d="M0 2a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v3h3a2 2 0 0 1 2 2v7a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2v-3H2a2 2 0 0 1-2-2V2zm2-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H2zm7.138 9.995c.193.301.402.583.63.846-.748.575-1.673 1.001-2.768 1.292.178.217.451.635.555.867 1.125-.359 2.08-.844 2.886-1.494.777.665 1.739 1.165 2.93 1.472.133-.254.414-.673.629-.89-1.125-.253-2.057-.694-2.82-1.284.681-.747 1.222-1.651 1.621-2.757H14V8h-3v1.047h.765c-.318.844-.74 1.546-1.272 2.13a6.066 6.066 0 0 1-.415-.492 1.988 1.988 0 0 1-.94.31z"/>--%>
                <%--                            </svg>--%>
                <%--                        </a>--%>
                <%--                        <ul class="dMenu dropdown-menu">--%>
                <%--                            <li><a class="dropdown-item text-white" href="#" id="navLang">En</a></li>--%>
                <%--                            <li><a class="dropdown-item text-white" href="#" id="navLang">Ua</a></li>--%>
                <%--                            <!-- <li><a class="dropdown-item text-white" href="#" id="navLang">Ru</a></li> -->--%>
                <%--                        </ul>--%>
                <%--                    </li>--%>
                <li class="nav-item m-1 justify-content-between d-inline-flex flex-nowrap align-self-center">
                    <c:if test="${sessionScope.user.isAdmin() == true}">
                        <div class="d-inline-flex flex-nowrap justify-content space-evenly">
                            <div class="m-1"><a role="button" class="btn btn-outline-light"
                                                href="createProduct"><fmt:message
                                    key="button.createProduct"/></a></div>
                            <div class="m-1"><a class="btn btn-outline-light" href="allUsers"><fmt:message
                                    key="button.manageUsers"/></a></div>
                            <div class="m-1"><a class="btn btn-outline-light" href="ordersAdmin"><fmt:message
                                    key="button.orders"/></a></div>
                        </div>
                    </c:if>
                    <c:if test="${sessionScope.user.isAdmin() == false}">
                        <div class="d-inline-flex flex-nowrap justify-content space-evenly">
                            <div class="m-1">
                                <div class="col"><a class="btn btn-outline-light" href="cart"><fmt:message
                                        key="button.myCart"/></a>
                                </div>
                            </div>
                            <div class="m-1">
                                <div class="col"><a class="btn btn-outline-light" href="ordersUser"><fmt:message
                                        key="button.myOrders"/></a></div>
                            </div>
                        </div>
                    </c:if>
                </li>
                <li class="nav-item m-1"><a href="login" class="btn btn-outline-light" role="button"><fmt:message
                        key="button.login"/></a></li>
                <li class="nav-item m-1"><a href="logout" class="btn btn-outline-light" role="button"><fmt:message
                        key="button.logout"/></a></li>
                <%--                    v1--%>
                <%--                <li class="nav-item m-1">--%>
                <%--                    <form class="m-0 p-0" action="changeLanguage" method="get">--%>

                <%--                        <c:if test="${sessionScope.language == ru}">--%>
                <%--                            <input type="hidden" name="language" value="en">--%>
                <%--                        </c:if>--%>

                <%--                        <c:if test="${sessionScope.language == en}">--%>
                <%--                            <input type="hidden" name="language" value="ru">--%>
                <%--                        </c:if>--%>

                <%--                        <c:if test="${sessionScope.language == ua}">--%>
                <%--                            <input type="hidden" name="language" value="ua">--%>
                <%--                        </c:if>--%>
                <%--                        <input type="submit" class="btn btn-outline-light" value="Change language">--%>
                <%--                    </form>--%>
                <%--                </li>--%>

                <%--                    v2--%>
                <%--                        <c:choose>--%>
                <%--                            <c:when test="${sessionScope.language == ru}">--%>
                <%--                                <input type="hidden" name="language" value="ru">--%>
                <%--                            </c:when>--%>
                <%--                            <c:when test="${sessionScope.language == ua}">--%>
                <%--                                <input type="hidden" name="language" value="ua">--%>
                <%--                            </c:when>--%>
                <%--                            <c:when test="${sessionScope.language == en}">--%>
                <%--                                <input type="hidden" name="language" value="en">--%>
                <%--                            </c:when>--%>
                <%--                        </c:choose>--%>

                <%--                    v3--%>
                <%--                <li class="nav-item m-1">--%>
                <%--                    <form class="m-0 p-0" action="changeLanguage" method="get">--%>
                <%--                        <c:if test="${sessionScope.language == ru}">--%>
                <%--                            <input type="hidden" name="language" value="ru">--%>
                <%--                        </c:if>--%>
                <%--                        <input type="submit" class="btn btn-outline-light" value="RU">--%>
                <%--                    </form>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item m-1">--%>
                <%--                    <form class="m-0 p-0" action="changeLanguage" method="get">--%>
                <%--                        <c:if test="${sessionScope.language == en}">--%>
                <%--                            <input type="hidden" name="language" value="en">--%>
                <%--                        </c:if>--%>
                <%--                        <input type="submit" class="btn btn-outline-light" value="EN">--%>
                <%--                    </form>--%>
                <%--                </li>--%>
                <%--                <li class="nav-item m-1">--%>
                <%--                    <form class="m-0 p-0" action="changeLanguage" method="get">--%>
                <%--                        <c:if test="${sessionScope.language == ua}">--%>
                <%--                            <input type="hidden" name="language" value="ua">--%>
                <%--                        </c:if>--%>
                <%--                        <input type="submit" class="btn btn-outline-light" value="UA">--%>
                <%--                    </form>--%>
                <%--                </li>--%>

                <%--                    v4--%>
                <li class="nav-item dropdown float-end">
                    <a class="nav-link dropdown-toggle text-white" href="#" role="button"
                       data-bs-toggle="dropdown">
                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
                             fill="currentColor" class="bi bi-translate" viewBox="0 0 16 16">
                            <path
                                    d="M4.545 6.714 4.11 8H3l1.862-5h1.284L8 8H6.833l-.435-1.286H4.545zm1.634-.736L5.5 3.956h-.049l-.679 2.022H6.18z"/>
                            <path
                                    d="M0 2a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v3h3a2 2 0 0 1 2 2v7a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2v-3H2a2 2 0 0 1-2-2V2zm2-1a1 1 0 0 0-1 1v7a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H2zm7.138 9.995c.193.301.402.583.63.846-.748.575-1.673 1.001-2.768 1.292.178.217.451.635.555.867 1.125-.359 2.08-.844 2.886-1.494.777.665 1.739 1.165 2.93 1.472.133-.254.414-.673.629-.89-1.125-.253-2.057-.694-2.82-1.284.681-.747 1.222-1.651 1.621-2.757H14V8h-3v1.047h.765c-.318.844-.74 1.546-1.272 2.13a6.066 6.066 0 0 1-.415-.492 1.988 1.988 0 0 1-.94.31z"/>
                        </svg>
                    </a>
                    <ul class="dropdown-menu justify-content-center align-items-center"
                        style="max-width: 50px; min-width: 50px; width: 50px !important; background-color:#464547;">
                        <li>
                            <form class="m-0 p-0" action="changeLanguage" method="get">
                                <c:if test="${sessionScope.language == ru}">
                                    <input type="hidden" name="language" value="ru">
                                </c:if>
                                <input type="submit" value="RU"
                                       class="btn dropdown-item text-white border-0;  margin-1; padding-0;"
                                       style="justify-content: center; background-color: #464547; color: whitesmoke;">
                            </form>
                        </li>
                        <li>
                            <form class="m-0 p-0" action="changeLanguage" method="get">
                                <c:if test="${sessionScope.language == en}">
                                    <input type="hidden" name="language" value="en">
                                </c:if>
                                <input type="submit" value="EN"
                                       class="btn dropdown-item text-white border-0;  margin-1; padding-0;"
                                       style="justify-content: center; background-color: #464547; color: whitesmoke;">
                            </form>
                        </li>
                        <li>
                            <form class="m-0 p-0" action="changeLanguage" method="get">
                                <c:if test="${sessionScope.language == ua}">
                                    <input type="hidden" name="language" value="ua">
                                </c:if>
                                <input type="submit" value="UA"
                                       class="btn dropdown-item text-white outline: none !important; border: none;  margin-1; padding-0;"
                                       style="justify-content: center; background-color: #464547; color: whitesmoke;">
                            </form>
                        </li>
                    </ul>
                </li>

            </ul>
        </div>
    </nav>
</header>

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
<link rel="stylesheet" href="css/header.css">
