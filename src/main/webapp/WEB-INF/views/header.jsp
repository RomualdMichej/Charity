<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<nav class="container container--70">
    <ul class="nav--actions">
         <sec:authorize access="not isAuthenticated()">
            <li><a href="/login">Zaloguj</a></li>
            <li class="highlighted"><a href="/user/register">Załóż konto</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <form action="<c:url value="/logout"/>" method="post">
                <li><a href="/logout">Wyloguj</a></li>
            </form>
        </sec:authorize>
        <li><a href="hi/">HI</a></li>

    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#" class="btn btn--without-border">O nas</a></li>
        <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
</html>

<%--<c:choose>--%>
<%--    <c:when test="${condition1}">--%>
<%--        // Jeżeli warunek jest prawdziwy--%>
<%--    </c:when>--%>
<%--    <c:when test="${condition2}">--%>
<%--        // Jeżeli warunek jest prawdziwy--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        // Jeżeli żaden powyższy nie był prawdziwy--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>


