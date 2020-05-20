<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
        <title>Document</title>

        <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
    </head>
    <body>
    <header class="header--main-page">
        <%@ include file="/WEB-INF/views/header.jsp" %>
<%--        <nav class="container container--70">--%>
<%--            <ul class="nav--actions">--%>
<%--                <li><a href="" class="btn btn--small btn--without-border">Zaloguj</a></li>--%>
<%--                <li><a href="#" class="btn btn--small btn--highlighted">Załóż konto</a></li>--%>
<%--            </ul>--%>
<%--            <%@ include file="/WEB-INF/views/header.jsp" %>--%>
<%--        </nav>--%>
        <div class="slogan container container--90">
            <div class="slogan--item">
                <h1>
                    Zacznij pomagać!<br/>
                    Oddaj niechciane rzeczy w zaufane ręce
                </h1>
            </div>
        </div>
    </header>
    <section class="stats">
        <div class="container container--85">
            <div class="stats--item">
                <em>${quantity}</em>

                <h3>Oddanych worków</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                    tempora!</p>
            </div>

            <div class="stats--item">
                <em>${donationQuantity}</em>
                <h3>Przekazanych darów</h3>
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                    quam.</p>
            </div>

        </div>
    </section>

    <section class="steps">
        <a href="/donation/" class="btn btn--large">ODDAJ RZECZY</a>
    </section>

    <section class="steps">
        <h2>Wystarczą 4 proste kroki</h2>

        <div class="steps--container">
            <div class="steps--item">
                <span class="icon icon--hands"></span>
                <h3>Wybierz rzeczy</h3>
                <p>ubrania, zabawki, sprzęt i inne</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--arrow"></span>
                <h3>Spakuj je</h3>
                <p>skorzystaj z worków na śmieci</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--glasses"></span>
                <h3>Zdecyduj komu chcesz pomóc</h3>
                <p>wybierz zaufane miejsce</p>
            </div>
            <div class="steps--item">
                <span class="icon icon--courier"></span>
                <h3>Zamów kuriera</h3>
                <p>kurier przyjedzie w dogodnym terminie</p>
            </div>
        </div>

        <a href="#" class="btn btn--large">Załóż konto</a>
    </section>

    <section class="about-us">
        <div class="about-us--text">
            <h2>O nas</h2>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
                optio esse quisquam illo omnis.</p>
            <img src="<c:url value="resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
        </div>
        <div class="about-us--image"><img src="<c:url value="resources/images/about-us.jpg"/>" alt="People in circle"/>
        </div>
    </section>

    <section class="help">
        <h2>Komu pomagamy?</h2>

        <!-- SLIDE 1 -->
        <div class="help--slides active" data-id="1">
            <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
                Możesz sprawdzić czym się zajmują.</p>

            <ul class="help--slides-items">
                <c:forEach items="${allInstitutions}" var="institution" step="2" varStatus="loopStatus">
                    <li>
                        <c:forEach items="${allInstitutions}" begin="${loopStatus.index}" end="${loopStatus.index +1}" var="institution">
                            <div class="col">
                                <div class="title">Fundacja "${institution.name}"</div>
                                <div class="subtitle">Cel i misja: ${institution.description}.</div>
                            </div>
                        </c:forEach>
                    </li>
                </c:forEach>
            </ul>
        </div>

    </section>
    <%@ include file="/WEB-INF/views/footer.jsp" %>

    <script src="<c:url value="resources/js/app.js"/>"></script>
    </body>
</html>
