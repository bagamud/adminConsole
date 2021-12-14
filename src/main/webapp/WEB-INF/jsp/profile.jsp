<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="ru">
<head>
    <jsp:include page="../template/_metaStyle.jsp"/>
    <style>
        fieldset {
            border: 1px groove #ddd !important;
            padding: 0 1.4em 1.4em 1.4em !important;
            margin: 0 0 1em 0 !important;
        }

        legend {
            font-size: 1.2em !important;
            font-weight: bold !important;
            text-align: left !important;
        }
    </style>
    <title>Вещественные доказательства</title>
</head>
<body class="" style="background-color: rgba(205,219,245,0.39)">

<jsp:include page="../template/_menu.jsp"/>
<div class="card m-auto col-md-10 order-md-1">
    <div class="m-auto h2">
        Карточка материала
    </div>
    <form class="needs-validation" action="${pageContext.request.contextPath}/manager" method="post" name="form"
          id="formId">
        <input type="number" id="id" name="id" value="${proceeding.id}" hidden/>
        <div class="row m-3">
            <div class="col-md-3">
                <label for="proceedingsType">Тип материала</label>
                <select class="form-control custom-select d-block w-100" id="proceedingsType"
                        name="proceedingsType">
                    <option value="${proceeding.proceedingsType.id}">${proceeding.proceedingsType.title}</option>
                    <core:forEach items="${proceedingsType}" var="type">
                        <option value="${type.id}">${type.title}</option>
                    </core:forEach>
                </select></div>
            <div class="col-md-3">
                <label for="proceedingsStatus">Статус</label>
                <select class="form-control custom-select d-block w-100" id="proceedingsStatus"
                        name="proceedingsStatus">
                    <option value="${proceeding.proceedingsStatus.id}">${proceeding.proceedingsStatus.title}</option>
                    <core:forEach items="${proceedingsStatus}" var="status">
                        <option value="${status.id}">${status.title}</option>
                    </core:forEach>

                </select>
            </div>
            <div class="col-md-3">
                <label for="department">Орган внутренних дел</label>
                <select class="form-control custom-select d-block w-100"
                        id="department"
                        name="department">
                    <option value="${proceeding.department.id}">${proceeding.department.shortTitle}</option>
                    <core:forEach items="${departments}" var="department">
                        <option value="${department.id}">${department.shortTitle}</option>
                    </core:forEach>

                </select>
            </div>
            <div class="col-md-3">
                <label for="services">Служба</label>
                <select class="form-control custom-select d-block w-100"
                        id="services"
                        name="services">
<%--                    <option value="${proceeding.services.id}">${proceeding.services.title}</option>--%>
                    <core:forEach items="${services}" var="department">
                        <option value="${services.id}">${services.title}</option>
                    </core:forEach>
                </select>
            </div>
        </div>
        <div class="row m-3">
            <div class="col-md-4 mb-3">
                <label for="caseNumber">Номер</label>
                <div class="input-group">
                    <input class="form-control <%if (request.getAttribute("error") != null) out.print("is-invalid");%>"
                           id="caseNumber" type="number" min="0" pattern="^[0-9]+$" name="caseNumber"
                           value="${proceeding.caseNumber}">
                    <div class="invalid-feedback">
                        Неправильный номер записи
                    </div>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit"
                                formaction="${pageContext.request.contextPath}/manager/get"
                                formmethod="get" formnovalidate>Поиск
                        </button>
                    </div>
                </div>
            </div>
            <div class="col-md-2">
                <label for="initiationDate">Дата регистрации</label>
                <div class="input-group">
                    <input class="form-control" id="initiationDate" type="date" name="initiationDate"
                           value="${proceeding.initiationDate.toLocalDate()}" required>
                </div>
            </div>
            <div class="col-md-3 mb-3" id="articleKoAPdiv" hidden>
                <label for="articleKoAP">Статья</label>
                <select class="form-control custom-select d-block"
                        id="articleKoAP"
                        name="article">
                    <option value="${proceeding.article.id}">${proceeding.article.title}</option>
                    <core:forEach items="${articlesKoAP}" var="article">
                        <option value="${article.id}">${article.title}</option>
                    </core:forEach>
                </select>
            </div>
            <div class="col-md-3 mb-3" id="articleUKdiv">
                <label for="articleUK">Статья</label>
                <select class="form-control custom-select d-block"
                        id="articleUK"
                        name="article">
                    <option value="${proceeding.article.id}">${proceeding.article.title}</option>
                    <core:forEach items="${articlesUK}" var="article">
                        <option value="${article.id}">${article.title}</option>
                    </core:forEach>
                </select>
            </div>

            <div class="col-md-3 mb-3">
                <label for="code">Кодекс</label>
                <select class="form-control custom-select d-block"
                        id="code"
                        name="code" onchange="articlesByCode()">
                    <option value="${proceeding.code.id}">${proceeding.code.shortTitle}</option>
                    <core:forEach items="${code}" var="code">
                        <option value="${code.id}">${code.shortTitle}</option>
                    </core:forEach>
                </select>
            </div>
        </div>
        <div class="row m-3">
            <div class="col-md-4 mb-3">
                <label for="post">Должность</label>
                <select class="form-control custom-select d-block w-100"
                        id="post"
                        name="post">
                    <option value="${proceeding.post.id}">${proceeding.post.title}</option>
                    <core:forEach items="${post}" var="post">
                        <option value="${post.id}">${post.title}</option>
                    </core:forEach>
                </select>
            </div>
            <div class="col-md-4 mb-3">
            <label for="rank">Звание</label>
            <select class="form-control custom-select d-block w-100"
                    id="rank"
                    name="rank">
                <option value="${proceeding.rank.id}">${proceeding.rank.title}</option>
                <core:forEach items="${rank}" var="rank">
                    <option value="${rank.id}">${rank.title}</option>
                </core:forEach>
            </select>
        </div>

            <div class="col-md-4 mb-3">
                <label for="fullName">ФИО</label>
                <input class="form-control"
                       id="fullName" type="text" name="fullName"
                       value="${proceeding.fullName}">
            </div>

        </div>
        <div class="row m-3">
            <div class="col-auto btn-group-sm">
                <input class="btn btn-primary" type="submit" value="Сохранить"
                       formaction="${pageContext.request.contextPath}/manager/add"/>
                <input class="btn btn-primary" type="button"
                       onclick="location.href='${pageContext.request.contextPath}/manager'"
                       value="Новый"/>

                <%--                <input class="btn btn-primary" type="button"--%>
                <%--                       onclick="history.back()"--%>
                <%--                       value="Назад"/>--%>
            </div>


        </div>
    </form>

</div>

<div class="card mt-3 m-auto col-md-10 order-md-1">
    <div class="card-header text-center">
        <div class="row m-auto">
            <div class="col-1"></div>
            <div class="col-10"><b>Вещественные доказательства</b></div>
            <div class="col-1 d-md-flex justify-content-md-end">
                <input class="btn-sm btn-primary" type="button" value="Добавить"
                       onclick="location.href='${pageContext.request.contextPath}/evidences?id=${proceeding.id}'">
            </div>
        </div>
        <div class="card-bodm-3 row">
            <div class="ms-sm-auto overflow-auto">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <core:forEach items="${materialEvidences}" var="evidence">
                            <tr onclick="location.href='${pageContext.request.contextPath}/evidences/get?id=${evidence.id}'">
                                <td>${evidence.id}</td>
                                <td><p>${evidence.proceedings.proceedingsType.title}
                                    № ${evidence.proceedings.caseNumber}
                                    от ${evidence.proceedings.initiationDate.toLocaleString().substring(0, 10)}</p>
                                    <p>${evidence.proceedings.department.shortTitle}</p></td>
                                <td><p>${evidence.evidenceType.title}</p>
                                    <p>${evidence.description}</p></td>
                            </tr>
                        </core:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // let control = document.getElementById('control').value;
    // if (control !== null && control !== '') {
    //     document.getElementById('control').style.backgroundColor = 'red';
    // }
    // const elements = document.getElementsByClassName("form-control");
    // for (let i = 0; i < elements.length; i++) {
    //     if (elements[i].nodeName === "INPUT") {
    //         elements[i].setAttribute("title", elements[i].value);
    //     } else if (elements[i].nodeName === "SELECT") {
    //         elements[i].setAttribute("title", elements[i].selectedOptions[0].text);
    //     }
    // }
    // document.getElementById("foundDate").setAttribute('max', new Date().toISOString().substring(0, 10));
    //
    // function articlesByCode() {
    //     if (document.getElementById("code").options.selectedIndex === 1) {
    //         document.getElementById("articleKoAPdiv").hidden = false;
    //         document.getElementById("articleUKdiv").hidden = true;
    //     } else if (document.getElementById("code").options.selectedIndex === 2) {
    //         document.getElementById("articleUKdiv").hidden = false;
    //         document.getElementById("articleKoAPdiv").hidden = true;
    //     }
    // }
    ${result}
</script>
<jsp:include page="../template/_footer.jsp"/>
</body>
</html>