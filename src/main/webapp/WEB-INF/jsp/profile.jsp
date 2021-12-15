<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <title>Консоль администратора</title>
</head>
<body class="">

<%--<jsp:include page="../template/_menu.jsp"/>--%>
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
                <button class="btn btn-sm btn-outline-light"
                        onclick="location.href='${pageContext.request.contextPath}/logout'">Выход
                </button>
            </div>
        </div>
    </div>
    <div class="b-example-divider"></div>
    <div class=" d-flex flex-column m-3 p-3">
        <div class="text-center h2">
            Профиль пользователя
        </div>
        <form class="needs-validation" action="${pageContext.request.contextPath}/profile" method="post" name="form"
              id="formId">
            <div class="row m-3">
                <div class="col-md-2 mb-3" hidden>
                    <label for="id">#</label>
                    <div class="input-group">
                        <input class="form-control"
                               readonly

                               id="id" type="number" name="id"
                               value="${userProfile.id}">
                    </div>
                </div>
                <div class="col-md-1 mb-3">
                    <label for="idUser">ID</label>
                    <div class="input-group">
                        <input class="form-control"
                               readonly
                               id="idUser" type="number" name="idUser"
                               value="${userProfile.idUser}">
                    </div>
                </div>
                <div class="col-md-2 mb-3">
                    <label for="username">Имя пользователя</label>
                    <div class="input-group">
                        <input class="form-control"
                               id="username" type="text" name="username"
                               value="${userProfile.username}">
                    </div>
                </div>
                <div class="col-md-3 mb-3">
                    <label for="lastName">Фамилия</label>
                    <div class="input-group">
                        <input class="form-control"
                               id="lastName" type="text" name="lastName"
                               value="${userProfile.lastName}">
                    </div>
                </div>
                <div class="col-md-2 mb-3">
                    <label for="firstName">Имя</label>
                    <div class="input-group">
                        <input class="form-control"
                               id="firstName" type="text" name="firstName"
                               value="${userProfile.firstName}">
                    </div>
                </div>
                <div class="col-md-2 mb-3">
                    <label for="surname">Отчество</label>
                    <div class="input-group">
                        <input class="form-control"
                               id="surname" type="text" name="surname"
                               value="${userProfile.surname}">
                    </div>
                </div>
                <div class="col-md-2 mb-3">
                    <label for="snils">СНИЛС</label>
                    <div class="input-group">
                        <input class="form-control"
                               id="snils" type="text" name="snils"
                               value="${userProfile.snils}">
                    </div>
                </div>
            </div>
            <div class="row m-3">
                <div class="col-md-3 mb-3">
                    <label for="rank">Звание</label>
                    <select class="form-control custom-select d-block w-100"
                            id="rank"
                            name="rank">
                        <option value="${userProfile.rank.id}">${userProfile.rank.title}</option>
                        <core:forEach items="${rank}" var="rank">
                            <option value="${rank.id}">${rank.title}</option>
                        </core:forEach>
                    </select>
                </div>
                <div class="col-md-5 mb-3">
                    <label for="post">Должность</label>
                    <select class="form-control custom-select d-block w-100"
                            id="post"
                            name="post">
                        <option value="${userProfile.post.id}">${userProfile.post.title}</option>
                        <core:forEach items="${post}" var="post">
                            <option value="${post.id}">${post.title}</option>
                        </core:forEach>
                    </select>
                </div>
                <div class="col-md-4">
                    <label for="department">Подразделение</label>
                    <select class="form-control custom-select d-block w-100"
                            id="department"
                            name="department">
                        <option value="${userProfile.department.id}">${userProfile.department.shortTitle}</option>
                        <core:forEach items="${departments}" var="department">
                            <option value="${department.id}">${department.shortTitle}</option>
                        </core:forEach>
                    </select>
                </div>
            </div>
            <div class="row m-3">
                <div class="col-md-4 mb-3">
                    <label for="email">Почта</label>
                    <input class="form-control"
                           id="email" type="email" name="email"
                           value="${userProfile.email}">
                </div>
                <div class="col-md-4 mb-3">
                    <label for="contacts">Контакты</label>
                    <input class="form-control"
                           id="contacts" type="text" name="contacts"
                           value="${userProfile.contacts}">
                </div>
                <div class="col-md-4 mb-3">
                    <label for="role">Роль</label>
                    <select class="form-control custom-select d-block w-100"
                            id="role"
                            name="role">
                        <option value="${user.role.id}">${user.role.name}</option>
                        <core:forEach items="${roles}" var="role">
                            <option value="${role.id}">${role.name}</option>
                        </core:forEach>
                    </select>
                </div>

<%--                <div class="col-md-4 mb-3">--%>
<%--                    <label for="active">Активность</label>--%>
<%--                    <select class="form-control custom-select d-block w-100"--%>
<%--                            id="active"--%>
<%--                            name="active">--%>
<%--                        <option value="${user.active.id}">${user.active.title}</option>--%>
<%--                        <core:forEach items="${active}" var="active">--%>
<%--                            <option value="${active.id}">${active.title}</option>--%>
<%--                        </core:forEach>--%>
<%--                    </select>--%>
<%--                </div>--%>
            </div>
            <div class="row m-3">
                <div class="col-auto btn-group-sm">
                    <input class="btn btn-primary" type="submit" value="Сохранить"
                           formaction="${pageContext.request.contextPath}/users/save"/>
                    <input class="btn btn-primary" type="button"
                           onclick="location.href='${pageContext.request.contextPath}/users/profile'"
                           value="Очистить"/>
                    <input class="btn btn-primary" type="button"
                           onclick="location.href='${pageContext.request.contextPath}/users'"
                           value="Назад"/>
                </div>
            </div>
        </form>
    </div>
</main>

<script>
    if ('${resultMessage}' !== '') {
    alert('${resultMessage}');}
</script>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>
