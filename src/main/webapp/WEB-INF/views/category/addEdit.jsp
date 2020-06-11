<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<h1>DODAWANIE NOWYCH KATEGOEII</h1>

<section class="steps">

<form:form method="post"
           modelAttribute="category">
    <div data-step="2">
        <div class="form-group form-group--inline">
            <form:hidden path="id"/> <br />
            <form:input path="name" type="text" placeholder="Nazwa"/> <br />
        </div>
    </div>
    <h1><input type="submit" value="Zapisz!"/></h1>

</form:form>
</section>

<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>