<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Training Courses</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css">
</head>
<body>
<header>
    <nav class="main-nav" data-js-main-nav>
        <div class="main-logo">
            <img src="${pageContext.request.contextPath}/assets/images/index/logo.jpg" alt="логотип">
        </div>

        <ul>
            <li><a href="${pageContext.request.contextPath}/index.jsp">Главная</a></li>
            <li><a href="${pageContext.request.contextPath}/courses.jsp">Курсы</a></li>
            <li><a href="${pageContext.request.contextPath}/contacts.jsp">Контакты</a></li>
        </ul>

        <div class="enter-logo" data-js-enter-logo>
            <img src="${pageContext.request.contextPath}/assets/images/index/autorization.png" alt="авторизация">
        </div>
    </nav>

    <!-- Попап авторизации -->
    <div id="popup" class="hidden" data-js-popup>
        <div class="popup-content" data-js-popup-content>
            <form action="${pageContext.request.contextPath}/enter" method="post">
                <div class="enter-user">
                    <ul>
                        <li><label>login</label><input type="text" name="login" required></li>
                        <li><label>email</label><input type="text" name="email" required></li>
                        <li><label>password</label><input type="password" name="password" required></li>
                        <li><label>message</label><input type="text" name="message" required></li>
                        <li>
                            <button type="submit">войти</button>
                            <button type="button">регистрация</button>
                        </li>
                    </ul>
                </div>
            </form>
        </div>
    </div>
</header>

<main>
    <div class="content">
        <h1>Список курсов</h1>
        <p>Количество курсов: ${fn:length(courses)}</p>

        <div class="grid">
            <!-- Цикл по курсам -->
            <c:forEach var="course" items="${courses}">
                <div class="grid_item">
                    <a href="${pageContext.request.contextPath}/courseDetails.jsp?id=${course.id}">
                            <p>${course.id}</p>
                            <p>${course.name}</p>
                            <p>${course.price}</p>
                    </a>
                </div>
            </c:forEach>

            <!-- Если список пустой -->
            <c:if test="${fn:length(courses) == 0}">
                <p>Курсы пока отсутствуют.</p>
            </c:if>
        </div>
    </div>
</main>

<footer>
</footer>

<script src="${pageContext.request.contextPath}/assets/js/script.js"></script>
</body>
</html>
