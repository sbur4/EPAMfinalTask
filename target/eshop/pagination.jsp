<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pricetag" uri="/WEB-INF/tld/price.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<%@page import="java.util.List" %>


<section class="drinkClass position-relative">

    <div class="sortBy row justify-content-center align-self-center g-3">
        <%--            <div class="col-1">sort by</div>--%>

        <%--            <div class="col-1 text-white rounded-3 m-2">--%>
        <%--                <button type="button" class="btn btn-secondary">aZ</button>--%>
        <%--                <button type="button" class="btn btn-secondary">Za</button>--%>
        <%--            </div>--%>

        <%--            +--%>
        <%--            <div class="col-1 text-white rounded-3 m-2">--%>
        <%--                <button type="button" class="btn btn-secondary">aZ</button>--%>
        <%--                <button type="button" class="btn btn-secondary">Za</button>--%>
        <%--            </div>--%>


        <%--            <div class="col-2 text-white rounded-3 m-2 ">--%>

        <%--                <form action="sortByPrice">--%>
        <%--                    &lt;%&ndash;                    <input data-toggle="button" type="submit" class="btn btn-secondary" value="price &#8595">&ndash;%&gt;--%>
        <%--                    <input type="hidden" name="${products}"/>--%>
        <%--                    <button data-toggle="button" type="submit" class="btn btn-secondary" value="submit"><a--%>
        <%--                            href="${request.getAttribute("sortByPrice")}">price &#8595</a></button>--%>
        <%--                </form>--%>

        <%--                &lt;%&ndash;                <%= request.getAttribute("sortByPrice")%>&ndash;%&gt;--%>
        <%--                &lt;%&ndash;                <input type="hidden" name="sortByPrice"/>&ndash;%&gt;--%>
        <%--                <button data-toggle="button" type="button" class="btn btn-secondary">PRICE &#8593</button>--%>
        <%--            </div>--%>
        <%--            +--%>

        <%--            <div class="col-2 text-white rounded-3 m-2">--%>
        <%--                <button data-toggle="button" type="button" class="btn btn-secondary">price &#8595</button>--%>
        <%--                <button data-toggle="button" type="button" class="btn btn-secondary">PRICE &#8593</button>--%>
        <%--            </div>--%>

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

        <%--            +--%>
        <%--            <div class="col-2 rounded-3 m-2">--%>
        <%--                <div class="btn-group">--%>
        <%--                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"--%>
        <%--                            data-bs-toggle="dropdown" aria-expanded="false">Capacity--%>
        <%--                    </button>--%>
        <%--                    <ul class="dropdown-menu">--%>
        <%--                        <li><a class="dropdown-item" href="#">All</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">330ml</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">500ml</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">750ml</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">1L</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">1.5L</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">2L</a></li>--%>
        <%--                    </ul>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            <div class="col-2 rounded-3 m-2">--%>
        <%--                <div class="btn-group">--%>
        <%--                    <button type="button" class="btn btn-secondary text-white dropdown-toggle"--%>
        <%--                            data-bs-toggle="dropdown" aria-expanded="false">Material--%>
        <%--                    </button>--%>
        <%--                    <ul class="dropdown-menu">--%>
        <%--                        <li><a class="dropdown-item" href="#">All</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">Plastic</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">Glass</a></li>--%>
        <%--                        <li><a class="dropdown-item" href="#">Metal</a></li>--%>
        <%--                    </ul>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            +--%>

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


        <%--         pagination java--%>

        <div class="col-2 m-0">
            <nav aria-label="Page navigation example">
                <ul class="pagination pagination-md my-2">
                    <li class="page-item">
                        <span> Page ${page} of ${pageCount}</span><span> | </span>

                        <span>
            <c:choose>
                <c:when test="${page - 1 > 0}">
                    <a href="pageServlet?page=${page-1}&pageSize=${pageSize}">Previous</a>
                </c:when>
                <c:otherwise>
                    Previous
                </c:otherwise>
            </c:choose>
        </span>

                        <span>
            <c:forEach var="p" begin="${minPossiblePage}" end="${maxPossiblePage}">
                <c:choose>
                    <c:when test="${page == p}">${p}</c:when>
                    <c:otherwise>
                        <a href="pageServlet?page=${p}&pageSize=${pageSize}">${p}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </span>

                        <span>
            <c:choose>
                <c:when test="${page + 1 <= pageCount}">
                    <a href="pageServlet?page=${page+1}&pageSize=${pageSize}">Next</a>
                </c:when>
                <c:otherwise>
                    Next
                </c:otherwise>
            </c:choose>
            </span>
                    </li>
                </ul>
            </nav>
        </div>
    </div>


    <%-- product list--%>
    <div class="drinkConteiner m-2">
        <div class="m-3 align-content-center">
            <div class="table">
                <table class="table" id="tableSort" data-toggle="table">
                    <thead>
                    <tr>
                        <th data-field="id" data-sortable="true">id</th>
                        <th data-field="name" data-sortable="true">name</th>
                        <th data-field="description" data-sortable="true">description</th>
                        <th data-field="price" data-sortable="true">price</th>
                        <th>image</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${products}">
                        <tr>
                            <td>${product.id}</td>
                            <td class="drinkName">${product.name}</td>
                            <td class="litr">${product.description}</td>
                            <td id="drinkPrice">${product.price} <pricetag:priceSign/>
                                <div>
                                    <a class="btn btn-danger" href="product?id=${product.getId()}"
                                       role="button">Buy</a>
                                </div>
                            </td>
                            <td><img class="imgDrink" src="${product.getImage_url()}" alt="#" style="height: 150px">
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%--        <c:forEach var="product" items="${products}">--%>
        <%--            <div class="drinkList">
        <span><img class="imgDrink" src="${product.getImage_url()}" alt="#"></span>--%>
        <%--                <p class="litr">${product.getDescription()}</p>--%>
        <%--                <p class="drinkName">${product.getName()}</p>--%>
        <%--                <div class="drinkBuy">--%>
        <%--                    <div id="drinkPrice">${product.getPrice()} <pricetag:priceSign/></div>--%>
        <%--                    <div>--%>
        <%--                        <a class="btn btn-danger" href="product?id=${product.getId()}" role="button">Buy</a>--%>
        <%--                    </div>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--        </c:forEach>--%>

</section>

<%-- table sort--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.19.1/bootstrap-table.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.19.1/bootstrap-table.min.css" rel="stylesheet"/>
<script src="js/tableSort.js"></script>
