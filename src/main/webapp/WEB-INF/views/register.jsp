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
        <div class="form-group">
          <spring:input path="email" type="email" name="email" placeholder="Email" />
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
    </section>
    <%@ include file="/WEB-INF/views/footer.jsp" %>
  </body>
</html>
