<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Вещественные доказательства</title>
</head>
<body class="" style="background-color: rgba(205,219,245,0.39)">
<jsp:include page="../template/_menu.jsp"/>
<div class="card m-auto col-md-10 order-md-1">
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32">
                <use xlink:href="#bootstrap"></use>
            </svg>
            <span class="fs-4">Sidebar</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="#" class="nav-link active" aria-current="page">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#home"></use>
                    </svg>
                    Home
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#speedometer2"></use>
                    </svg>
                    Dashboard
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#table"></use>
                    </svg>
                    Orders
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#grid"></use>
                    </svg>
                    Products
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">
                        <use xlink:href="#people-circle"></use>
                    </svg>
                    Customers
                </a>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="" class="rounded-circle me-2" width="32" height="32">
                <strong>mdo</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">New project...</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="#">Sign out</a></li>
            </ul>
        </div>
    </div>
    <div class="card bg-light m-auto mt-3 col-md-10 order-md-1" <%--${hidden}--%>>
        <div class="m-3 row">
            <div class="ms-sm-auto overflow-auto">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <core:forEach items="${usersList}" var="user">
                            <tr onclick="location.href='${pageContext.request.contextPath}/get?username=${user.username}'">
                                <td>${user.id}</td>
                                <td>${user.idUser}</td>
                                <td>${user.username}</td>
                                <td>${user.lastName} ${user.firstName} ${user.surname}</td>
                                <td>${user.snils}
                                <td>${user.post.title}
                                <td>${user.department.shortTitle}</td>
                                <td>${user.email}</td>
                                <td>${user.contacts}</td>
                                <td>${user.active}</td>
                            </tr>
                        </core:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
