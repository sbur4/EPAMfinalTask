<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pricetag" uri="/WEB-INF/tld/price.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=chrome">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="drinks online shop"/>
    <meta name="keywords" content="drink, cola, sprite, fanta, water">
    <meta name="author" content="sburch">
    <title>Home | eShop</title>
    <!-- favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
</head>
<body>

<%@ include file="header.jsp" %>

<section class="drinkClass">
    <div class="container">
        <div class="sortBy row justify-content-center align-self-center g-3">
            <%--            <div class="col-1">sort by</div>--%>

            <%--                <div class="col-2 text-white rounded-3 m-2">--%>
            <%--                    <button type="button" class="btn btn-secondary">aZ</button>--%>
            <%--                    <button type="button" class="btn btn-secondary">Za</button>--%>
            <%--                </div>--%>

            <div class="col-2 text-white rounded-3 m-2">
                <div class="d-inline-flex">
                    <form method="get">
                        <input type="hidden" value="nameAsc" name="sortBy">
                        <button type="submit" class="btn btn-secondary mx-1"><fmt:message
                                key="button.nameAscSort"/></button>
                    </form>
                    <form method="get">
                        <input type="hidden" value="nameDesc" name="sortBy">
                        <button type="submit" class="btn btn-secondary  mx-1"><fmt:message
                                key="button.nameDescSort"/></button>
                    </form>
                </div>
            </div>

            <%--            <div class="col-2 text-white rounded-3 m-2">--%>
            <%--                <button data-toggle="button" type="button" class="btn btn-secondary">price &#8595</button>--%>
            <%--                <button data-toggle="button" type="button" class="btn btn-secondary">PRICE &#8593</button>--%>

            <div class="col-2 text-white rounded-3 m-2">
                <div class="d-inline-flex">
                    <form method="get">
                        <input type="hidden" value="lowPrice" name="sortBy">
                        <button type="submit" class="btn btn-secondary mx-1"><fmt:message
                                key="button.priceLowSort"/></button>
                    </form>
                    <form method="get">
                        <input type="hidden" value="highPrice" name="sortBy">
                        <button type="submit" class="btn btn-secondary mx-1"><fmt:message
                                key="button.priceHighSort"/></button>
                    </form>
                </div>
            </div>

            <%--            <div class="col-2 rounded-3 m-2">--%>
            <%--                <div class="btn-group">--%>
            <%--                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"--%>
            <%--                            data-bs-toggle="dropdown" aria-expanded="false">Category--%>
            <%--                    </button>--%>
            <%--                    <ul class="dropdown-menu">--%>
            <%--                        <li><a class="dropdown-item" href="#">All</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">Brand name</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">New</a></li>--%>
            <%--                    </ul>--%>
            <%--                </div>--%>
            <%--            </div>--%>

            <div class="col-2 rounded-3 m-2">
                <div class="btn-group">
                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"
                            data-bs-toggle="dropdown" aria-expanded="false"><fmt:message
                            key="button.capacity"/>
                    </button>
                    <ul class="dropdown-menu">
                        <form method="get">
                            <li>
                                <input type="hidden" value="all" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacityAll"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li>
                                <input type="hidden" value="capacity0_3" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity0_33"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li>
                                <input type="hidden" value="capacity0_5" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity0_5"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li><input type="hidden" value="capacity0_7" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity0_75"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li><input type="hidden" value="capacity1" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity1"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li><input type="hidden" value="capacity1_5" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity1_5"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li><input type="hidden" value="capacity2" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.capacity2"/></button>
                            </li>
                        </form>
                    </ul>
                </div>

            </div>

            <%--                <div class="col-2 rounded-3 m-2">--%>
            <%--                    <div class="btn-group">--%>
            <%--                        <button type="button" class="btn btn-secondary text-white dropdown-toggle"--%>
            <%--                                data-bs-toggle="dropdown" aria-expanded="false">Capacity--%>
            <%--                        </button>--%>
            <%--                        <ul class="dropdown-menu">--%>
            <%--                            <li><a class="dropdown-item" href="#">All</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">330ml</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">500ml</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">750ml</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">1L</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">1.5L</a></li>--%>
            <%--                            <li><a class="dropdown-item" href="#">2L</a></li>--%>
            <%--                        </ul>--%>
            <%--                    </div>--%>
            <%--                </div>--%>

            <div class="col-2 rounded-3 m-2">
                <div class="btn-group">
                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"
                            data-bs-toggle="dropdown" aria-expanded="false"><fmt:message
                            key="button.material"/></button>
                    <ul class="dropdown-menu">
                        <form  method="get">
                            <li>
                                <input type="hidden" value="all" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.materialAll"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li>
                                <input type="hidden" value="materialPlastic" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.materialPlastic"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li>
                                <input type="hidden" value="materialGlass" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.materialGlass"/></button>
                            </li>
                        </form>
                        <form method="get">
                            <li>
                                <input type="hidden" value="materialMetal" name="sortBy">
                                <button type="submit" class="dropdown-item" href="#"><fmt:message
                                        key="button.materialMetal"/></button>
                            </li>
                        </form>
                    </ul>
                </div>
            </div>
            <%--            <div class="col-1 rounded-3 m-2">--%>
            <%--                <div class="btn-group">--%>
            <%--                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"--%>
            <%--                            data-bs-toggle="dropdown" aria-expanded="false">Size--%>
            <%--                    </button>--%>
            <%--                    <ul class="dropdown-menu">--%>
            <%--                        <li><a class="dropdown-item" href="#">All</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">5</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">10</a></li>--%>
            <%--                        <li><a class="dropdown-item" href="#">15</a></li>--%>
            <%--                    </ul>--%>
            <%--                </div>--%>
            <%--            </div>--%>

            <%-- pagination --%>
            <div class="col-2 m-2">
                <nav>
                    <ul class="pagination pagination-md">
                        <li class="page-item"><span
                                class="page-link bg-secondary text-white border-0" style="width: 150px"> <fmt:message
                                key="label.pagePagination"/> ${page}  <fmt:message
                                key="label.ofPagination"/> ${pageCount}</span>
                        </li>
                        <li class="page-item">
                            <c:choose>
                                <c:when test="${page - 1 > 0}">
                                    <%--                                    <a href="home?page=${page-1}&pageSize=${pageSize}&sortBy=${param.sortBy}"--%>
                                    <a href="home?page=${page-1}&pageSize=${pageSize}&sortBy=${param.sortBy}"
                                       class="page-link bg-secondary text-white border-0" aria-label="Previous"
                                    ><span
                                            aria-hidden="true">&laquo;</span></a>
                                </c:when>
                                <c:otherwise>
                                    <span class="page-link bg-secondary text-white border-0">&laquo;</span>
                                </c:otherwise>
                            </c:choose>
                        </li>
                        <li class="page-link bg-secondary text-white border-0">
                            <c:forEach var="p" begin="${minPossiblePage}" end="${maxPossiblePage}">
                                <c:choose>
                                    <c:when
                                            test="${page == p}">${p}</c:when>
                                    <c:otherwise>
                                        <%--                                        <a href="home?page=${p}&pageSize=${pageSize}&sortBy=${param.sortBy}"--%>
                                        <a href="home?page=${p}&pageSize=${pageSize}&sortBy=${param.sortBy}"
                                           class="page-link bg-secondary text-white border-0">${p}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </li>
                        <li class="page-item">
                            <c:choose>
                                <c:when test="${page + 1 <= pageCount}">
                                    <%--                                    <a href="home?page=${page+1}&pageSize=${pageSize}&sortBy=${param.sortBy}"--%>
                                    <a href="home?page=${page+1}&pageSize=${pageSize}&sortBy=${param.sortBy}"
                                       class="page-link  bg-secondary text-white border-0" aria-label="Next"><span
                                            aria-hidden="true">&raquo;</span></a>
                                </c:when>
                                <c:otherwise>
                                    <span class="page-link bg-secondary text-white border-0">&raquo;</span>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>

    <%-- product list--%>
    <%--        <div class="m-3 align-content-center">--%>
    <%--            <div class="table">--%>
    <%--                <table class="table" id="tableSort" data-toggle="table">--%>
    <%--                    <thead>--%>
    <%--                    <tr>--%>
    <%--                        <th data-field="id" data-sortable="true">id</th>--%>
    <%--                        <th data-field="name" data-sortable="true">name</th>--%>
    <%--                        <th data-field="description" data-sortable="true">description</th>--%>
    <%--                        <th data-field="price" data-sortable="true">price</th>--%>
    <%--                        <th>image</th>--%>
    <%--                    </tr>--%>
    <%--                    </thead>--%>
    <%--                    <tbody>--%>
    <%--                    <c:forEach var="product" items="${products}">--%>
    <%--                        <tr>--%>
    <%--                            <td>${product.id}</td>--%>
    <%--                            <td class="drinkName">${product.name}</td>--%>
    <%--                            <td class="litr">${product.description}</td>--%>
    <%--                            <td id="drinkPrice">${product.price} <pricetag:priceSign/>--%>
    <%--                                <div>--%>
    <%--                                    <a class="btn btn-danger" href="product?id=${product.getId()}"--%>
    <%--                                       role="button">Buy</a>--%>
    <%--                                </div>--%>
    <%--                            </td>--%>
    <%--                            <td><img class="imgDrink" src="${product.getImage_url()}" alt="#" style="height: 150px">--%>
    <%--                            </td>--%>
    <%--                        </tr>--%>
    <%--                    </c:forEach>--%>
    <%--                    </tbody>--%>
    <%--                </table>--%>
    <%--            </div>--%>

    <div class="drinkContainer">
        <c:forEach var="product" items="${products}">
            <div class="drinkList"><span><img class="imgDrink" src="${product.getImage_url()}" alt="#"></span>
                <p class="litr">${product.getDescription()}</p>
                <p class="drinkName">${product.getName()}</p>
                <div class="drinkBuy">
                    <div id="drinkPrice">${product.getPrice()} <pricetag:priceSign/></div>
                    <div>
                        <a class="btn btn-danger" href="product?id=${product.getId()}" role="button"><fmt:message
                                key="button.buy"/></a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>


<%@ include file="footer.jsp" %>

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
<link rel="stylesheet" href="css/home.css">
<!-- js -->
<%--<link src="js/sortPrice.js">--%>

<%-- table sort--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.19.1/bootstrap-table.min.js"></script>--%>
<%--<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.19.1/bootstrap-table.min.css" rel="stylesheet"/>--%>
<%--<script src="js/tableSort.js"></script>--%>

</body>
</html>