<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Czy na pewno chcesz zablokować urzytkownika ${user.email}?</h1>
<input type="hidden" name="toRemoveId" value="${user.id}">
<h1><form:form method="post"
               modelAttribute="viewHelper">
    <form:hidden path="option" value="confirmed"/>
    <input type="submit" value="Tak!">
</form:form></h1>

<h1><form:form method="post"
               modelAttribute="viewHelper">
    <form:hidden path="option" value="non-confirmed"/>
    <input type="submit" value="Nie!">
</form:form></h1>

</body>
</html>