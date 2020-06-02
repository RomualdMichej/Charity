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
      <spring:form method="post" modelAttribute="donation">
        <div class="form-group">
          <spring:input path="city" placeholder="city" />
        </div>
        <div class="form-group">
          <spring:input path="street" placeholder="street" />
        </div>
        <div class="form-group">
          <spring:input path="quantity" placeholder="quantity" />
        </div>
        <div class="form-group">
          <spring:input path="zipCode" placeholder="zip" />
        </div>
        <div class="form-group">
          <spring:input type="text" path="pickUpDate" placeholder="pickUpDate" />
        </div>
        <div class="form-group">
          <spring:input type="time" path="pickUpTime" placeholder="pickUpTime" />
        </div>




        <div class="form-group">
        <spring:select path="institution.id" items="${institutionList}"
                     itemLabel="name" itemValue="id"/>
        </div>



        <div class="form-group">
          <spring:input path="pickUpComment" placeholder="pickUpComment" />
        </div>

        <div class="form-group form-group--buttons">
<%--          <a href="login.html" class="btn btn--without-border">Zaloguj się</a>--%>
          <button class="btn" type="submit">Oddaj</button>
        </div>
      </spring:form>
    </section>
    <%@ include file="/WEB-INF/views/footer.jsp" %>
  </body>
</html>
