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
<section class="steps">
<a href="/user/showAll" class="btn btn--large">Edycja urzytkowników</a>
</section>
<section class="steps">
    <a href="category/" class="btn btn--large">Edycja kategorji</a>
</section>
<section class="steps">
    <a href="institution/" class="btn btn--large">Edycja fundacji</a>
</section>
<section class="steps">
    <a href="donation/" class="btn btn--large">Edycja darowizn</a>
</section>
<%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>