<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
  </head>
  <body>
    <header>
      <%@ include file="/WEB-INF/views/header.jsp" %>
    </header>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <spring:form method="post" modelAttribute="user">
        <spring:hidden path="id"/>
        <spring:hidden path="enable"/>
        <div class="form-group">
          <spring:input path="email" type="email" name="email" placeholder="Email" />
        </div>
        <div class="form-group">
          <spring:input path="city" type="text" name="city" placeholder="miasto" />
        </div>
        <div class="form-group">
          <spring:input path="street" type="text" name="street" placeholder="adres" />
        </div>
        <div class="form-group">
          <spring:input path="zipCode" type="text" name="zipCode" placeholder="kod pocztowy" />
        </div>
        <c:if test="${not empty note}">
          <div class="form-group">
            <p class="nova">${note}</p>
          </div>
        </c:if>
        <div class="form-group">
          <spring:input path="password" type="password" name="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
          <spring:input path="password2" type="password" name="password2" placeholder="Powtórz hasło" />
        </div>

        <div class="form-group form-group--buttons">
          <a href="login.html" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </spring:form>
      <c:if test="${user.enable == 1}">
        <form method="get"
              action="ban">
          <input type="hidden" name="toBanId" value="${user.id}">
          <input type="submit" value="ZABLOKUJ UŻYTKOWNIKA">
        </form>

      </c:if>
      <c:if test="${user.enable == 2}">
        <form method="post"
              action="unban">
          <input type="hidden" name="toUnBanId" value="${user.id}">
          <input type="submit" value="ODBLOKUJ UŻYTKOWNIKA">
        </form>

      </c:if>
    </section>
    <%@ include file="/WEB-INF/views/footer.jsp" %>
  </body>
</html>
