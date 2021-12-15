<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Консоль администратора</title>
</head>
<body>
<main>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px;">
        <div class="d-flex align-items-center text-white text-decoration-none">
            <img alt="Russian Federation"
                 height="30"
                 src="${pageContext.request.contextPath}/img/gerb_mvdi-300x174.png"
                 class="m-1"
                 width="52"/>
            <span class="fs-4"></span>
        </div>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="${pageContext.request.contextPath}/users" class="nav-link active" aria-current="page">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-people-fill" viewBox="0 0 16 16">
                        <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        <path fill-rule="evenodd"
                              d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
                        <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
                    </svg>
                    Пользователи
                </a>
            </li>
            <li>
                <a href="#" class="nav-link text-white">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                         class="bi bi-book" viewBox="0 0 16 16">
                        <path d="M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811V2.828zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492V2.687zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
                    </svg>
                    Справочники
                </a>
            </li>
        </ul>
        <hr>
        <div class="row">
            <div class="col d-grid gap-2 d-md-flex justify-content-md-start">
                <strong>${user.lastName} ${user.firstName.substring(0, 1)}. ${user.surname.substring(0, 1)}.</strong>
            </div>
            <div class="col d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-sm btn-outline-light" onclick="location.href='${pageContext.request.contextPath}/logout'">Выход</button>
            </div>
        </div>
    </div>
    <div class="b-example-divider"></div>
    <div class="d-flex flex-column m-3 flex-shrink-0 p-3">
        <div class="d-flex ms-sm-auto overflow-auto">
            <table class="table table-hover table-responsive-sm">
                <thead>
                <tr class="text-center">
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">Имя пользователя</th>
                    <th scope="col">ФИО</th>
                    <th scope="col">СНИЛС</th>
                    <th scope="col">Должность</th>
                    <th scope="col">Подразделение</th>
                    <th scope="col">Почта</th>
                    <th scope="col">Контакты</th>
                    <th scope="col">Активен</th>
                </tr>
                </thead>
                <tbody>
                <core:forEach items="${usersList}" var="user">
                    <tr onclick="location.href='${pageContext.request.contextPath}/users/get?username=${user.username}'">
                        <td>${user.id}</td>
                        <td>${user.idUser}</td>
                        <td>${user.username}</td>
                        <td>${user.lastName} ${user.firstName} ${user.surname}</td>
                        <td>${user.snils}</td>
                        <td>${user.post.title}</td>
                        <td>${user.department.shortTitle}</td>
                        <td>${user.email}</td>
                        <td>${user.contacts}</td>
                        <td>${user.active}</td>
                    </tr>
                </core:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
